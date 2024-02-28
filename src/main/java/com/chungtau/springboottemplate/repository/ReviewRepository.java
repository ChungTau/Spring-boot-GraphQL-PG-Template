package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.entity.review.Review;

@GraphQlRepository
public interface ReviewRepository extends CrudRepository<Review, String>, QuerydslPredicateExecutor<Review> {
    
}
