package com.studentsphere.config;

import com.studentsphere.entity.Deal;
import com.studentsphere.entity.Internship;
import com.studentsphere.entity.Offer;
import com.studentsphere.entity.Task;

import com.studentsphere.repository.DealRepository;
import com.studentsphere.repository.InternshipRepository;
import com.studentsphere.repository.OfferRepository;
import com.studentsphere.repository.TaskRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeData(
            OfferRepository offerRepository,
            DealRepository dealRepository,
            InternshipRepository internshipRepository,
            TaskRepository taskRepository
    ) {

        return args -> {

            /* ========================================
               OFFERS
            ======================================== */

            if (offerRepository.count() == 0) {

                offerRepository.save(
                        new Offer(
                                "Myntra",
                                "🛍️",
                                "20% OFF",
                                "Student Fashion Discount",
                                "31 Dec 2026",
                                "Shopping",
                                "STUDENTMYNTRA20"
                        )
                );

                offerRepository.save(
                        new Offer(
                                "Zomato",
                                "🍔",
                                "₹150 OFF",
                                "Student Food Discount",
                                "31 Dec 2026",
                                "Food",
                                "STUDENTZOMATO150"
                        )
                );

                offerRepository.save(
                        new Offer(
                                "Spotify",
                                "🎵",
                                "50% OFF",
                                "Student Premium Plan",
                                "31 Dec 2026",
                                "Entertainment",
                                "STUDENTSPOTIFY50"
                        )
                );

                offerRepository.save(
                        new Offer(
                                "Amazon",
                                "📦",
                                "10% OFF",
                                "Student Shopping Offer",
                                "31 Dec 2026",
                                "Shopping",
                                "STUDENTAMAZON10"
                        )
                );

                offerRepository.save(
                        new Offer(
                                "BookMyShow",
                                "🎬",
                                "₹100 OFF",
                                "Student Movie Discount",
                                "31 Dec 2026",
                                "Entertainment",
                                "STUDENTBMS100"
                        )
                );

                offerRepository.save(
                        new Offer(
                                "Uber",
                                "🚕",
                                "₹200 OFF",
                                "Student Travel Discount",
                                "31 Dec 2026",
                                "Travel",
                                "STUDENTUBER200"
                        )
                );
            }


            /* ========================================
               DEALS
            ======================================== */

            if (dealRepository.count() == 0) {

                dealRepository.save(
                        new Deal(
                                "Campus Store",
                                "🎒",
                                "College Backpack",
                                "₹799",
                                "₹1299",
                                "38% OFF",
                                "Online",
                                "Fashion"
                        )
                );

                dealRepository.save(
                        new Deal(
                                "Student Cafe",
                                "☕",
                                "Coffee + Sandwich Combo",
                                "₹149",
                                "₹220",
                                "32% OFF",
                                "Offline",
                                "Food"
                        )
                );

                dealRepository.save(
                        new Deal(
                                "TechZone",
                                "🎧",
                                "Wireless Earphones",
                                "₹599",
                                "₹999",
                                "40% OFF",
                                "Online",
                                "Technology"
                        )
                );

                dealRepository.save(
                        new Deal(
                                "Print Hub",
                                "🖨️",
                                "100 Pages Printing",
                                "₹199",
                                "₹300",
                                "34% OFF",
                                "Offline",
                                "Education"
                        )
                );

                dealRepository.save(
                        new Deal(
                                "Movie Zone",
                                "🎬",
                                "Student Movie Ticket",
                                "₹199",
                                "₹300",
                                "34% OFF",
                                "Offline",
                                "Entertainment"
                        )
                );

                dealRepository.save(
                        new Deal(
                                "TravelGo",
                                "🚌",
                                "Student Bus Ticket",
                                "₹499",
                                "₹699",
                                "29% OFF",
                                "Online",
                                "Travel"
                        )
                );
            }


            /* ========================================
               INTERNSHIPS
            ======================================== */

            if (internshipRepository.count() == 0) {

                internshipRepository.save(
                        new Internship(
                                "TechNova",
                                "💻",
                                "Frontend Developer Intern",
                                "Development",
                                "₹15,000",
                                "3 Months",
                                "Remote",
                                "India",
                                "React, JavaScript, CSS"
                        )
                );

                internshipRepository.save(
                        new Internship(
                                "FinEdge",
                                "🏦",
                                "Backend Developer Intern",
                                "Development",
                                "₹18,000",
                                "6 Months",
                                "Hybrid",
                                "Mumbai",
                                "Java, Spring Boot, MySQL"
                        )
                );

                internshipRepository.save(
                        new Internship(
                                "Marketly",
                                "📢",
                                "Digital Marketing Intern",
                                "Marketing",
                                "₹10,000",
                                "3 Months",
                                "Remote",
                                "India",
                                "SEO, Social Media, Analytics"
                        )
                );

                internshipRepository.save(
                        new Internship(
                                "DataWorks",
                                "📊",
                                "AI/ML Intern",
                                "AI/ML",
                                "₹20,000",
                                "6 Months",
                                "Hybrid",
                                "Bengaluru",
                                "Python, Machine Learning, Pandas"
                        )
                );

                internshipRepository.save(
                        new Internship(
                                "DesignHub",
                                "🎨",
                                "UI/UX Design Intern",
                                "Design",
                                "₹12,000",
                                "3 Months",
                                "Remote",
                                "India",
                                "Figma, UI/UX"
                        )
                );

                internshipRepository.save(
                        new Internship(
                                "CyberShield",
                                "🔐",
                                "Cybersecurity Intern",
                                "Cybersecurity",
                                "₹16,000",
                                "4 Months",
                                "On-site",
                                "Pune",
                                "Networking, Linux, Security"
                        )
                );
            }


            /* ========================================
               REWARD TASKS
            ======================================== */

            if (taskRepository.count() == 0) {

                taskRepository.save(
                        new Task(
                                "Complete your profile",
                                "Add your college and other profile information.",
                                50,
                                "Easy",
                                "👤"
                        )
                );

                taskRepository.save(
                        new Task(
                                "Invite a friend",
                                "Invite another student to join StudentSphere.",
                                100,
                                "Easy",
                                "👥"
                        )
                );

                taskRepository.save(
                        new Task(
                                "Complete student survey",
                                "Help us improve StudentSphere by completing a short survey.",
                                75,
                                "Medium",
                                "📝"
                        )
                );

                taskRepository.save(
                        new Task(
                                "Discover 5 offers",
                                "Explore five student offers on StudentSphere.",
                                30,
                                "Easy",
                                "🎟️"
                        )
                );

                taskRepository.save(
                        new Task(
                                "Give feedback",
                                "Share your feedback about StudentSphere.",
                                50,
                                "Medium",
                                "⭐"
                        )
                );
            }


            /* ========================================
               CONSOLE INFORMATION
            ======================================== */

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "StudentSphere data initialization complete."
            );

            System.out.println(
                    "Offers: " + offerRepository.count()
            );

            System.out.println(
                    "Deals: " + dealRepository.count()
            );

            System.out.println(
                    "Internships: " + internshipRepository.count()
            );

            System.out.println(
                    "Tasks: " + taskRepository.count()
            );

            System.out.println(
                    "========================================"
            );
        };
    }
}