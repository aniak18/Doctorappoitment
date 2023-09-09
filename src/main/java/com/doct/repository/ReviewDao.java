package com.doct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doct.entity.Review;

public interface ReviewDao extends JpaRepository<Review, Integer> {

}
