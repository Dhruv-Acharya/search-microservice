package com.lelo.searchmicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "productid", type = "product")
public class Product {
    @Id
    private String productId;

    private String name;
    private String usp;
    private String description;
    private String imageUrl;
    private double rating;
    private double ratingCounter;
    private String priceRange;

    public Product() {
    }

    public Product(String productId, String name, String usp, String description, String imageUrl, double rating, double ratingCounter, String priceRange) {
        this.productId = productId;
        this.name = name;
        this.usp = usp;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.ratingCounter = ratingCounter;
        this.priceRange = priceRange;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(double ratingCounter) {
        this.ratingCounter = ratingCounter;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
