package com.studentsphere.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtService jwtService;


    public JwtAuthenticationFilter(
            JwtService jwtService
    ) {

        this.jwtService = jwtService;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {


        /*
         * ========================================
         * CORS PREFLIGHT
         * ========================================
         *
         * Browser sends OPTIONS request before
         * certain cross-origin requests.
         *
         * We must allow it through.
         */

        if (
                "OPTIONS".equalsIgnoreCase(
                        request.getMethod()
                )
        ) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }


        /*
         * ========================================
         * GET AUTHORIZATION HEADER
         * ========================================
         */

        String authorizationHeader =
                request.getHeader(
                        "Authorization"
                );


        /*
         * ========================================
         * NO TOKEN
         * ========================================
         *
         * We don't reject the request here.
         *
         * Public endpoints such as:
         *
         * /api/offers
         * /api/deals
         * /api/internships
         * /api/tasks
         *
         * can continue normally.
         */

        if (
                authorizationHeader == null ||
                        !authorizationHeader.startsWith(
                                "Bearer "
                        )
        ) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }


        /*
         * ========================================
         * EXTRACT TOKEN
         * ========================================
         */

        String token =
                authorizationHeader.substring(7);


        try {

            /*
             * ====================================
             * VALIDATE TOKEN
             * ====================================
             */

            if (
                    jwtService.isTokenValid(token)
            ) {

                /*
                 * Extract user's email.
                 */
                String email =
                        jwtService.getEmailFromToken(
                                token
                        );


                /*
                 * Don't create another
                 * authentication if one already
                 * exists.
                 */
                if (
                        email != null &&
                                SecurityContextHolder
                                        .getContext()
                                        .getAuthentication()
                                        == null
                ) {

                    /*
                     * Create authenticated user.
                     *
                     * Principal = user's email.
                     */
                    UsernamePasswordAuthenticationToken
                            authentication =
                            new UsernamePasswordAuthenticationToken(
                                    email,
                                    null,
                                    Collections.emptyList()
                            );


                    /*
                     * Add request details.
                     */
                    authentication.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );


                    /*
                     * Store authentication in
                     * Spring Security context.
                     */
                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(
                                    authentication
                            );
                }
            }

        } catch (Exception exception) {

            /*
             * Invalid or expired JWT.
             *
             * Clear authentication and allow
             * Spring Security to handle the
             * protected request.
             */

            SecurityContextHolder
                    .clearContext();
        }


        /*
         * Continue request.
         */
        filterChain.doFilter(
                request,
                response
        );
    }
}