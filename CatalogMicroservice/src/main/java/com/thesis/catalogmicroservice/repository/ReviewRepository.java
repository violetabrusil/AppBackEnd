package com.thesis.catalogmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesis.catalogmicroservice.audiobook.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
