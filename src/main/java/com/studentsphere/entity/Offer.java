package com.studentsphere.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String brand;

    private String logo;

    private String discount;

    private String title;

    private String expiry;

    private String category;

    @Column(name = "coupon_code")
    private String couponCode;

    public Offer() {
    }

    public Offer(
            String brand,
            String logo,
            String discount,
            String title,
            String expiry,
            String category,
            String couponCode
    ) {
        this.brand = brand;
        this.logo = logo;
        this.discount = discount;
        this.title = title;
        this.expiry = expiry;
        this.category = category;
        this.couponCode = couponCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}