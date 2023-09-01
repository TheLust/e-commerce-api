package com.iongroup.ecommerceapi.service.interfaces;

import com.iongroup.ecommerceapi.entity.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {
    Optional<Review> findById(Long id);
    List<Review> findAll();
    void save(Review review);
    void update(Review review, Review updatedReview);
    void delete(Long id);
}
