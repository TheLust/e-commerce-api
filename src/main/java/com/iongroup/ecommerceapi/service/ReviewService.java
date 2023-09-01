package com.iongroup.ecommerceapi.service;

import com.iongroup.ecommerceapi.entity.Review;
import com.iongroup.ecommerceapi.repository.ReviewRepository;
import com.iongroup.ecommerceapi.service.interfaces.IReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void update(Review review, Review updatedReview) {
        BeanUtils.copyProperties(updatedReview, review,
                "id", "user", "product");
        reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
