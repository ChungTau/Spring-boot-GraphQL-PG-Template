package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.entity.category.Category;

@GraphQlRepository
public interface CategoryRepository extends CrudRepository<Category, String>, QuerydslPredicateExecutor<Category> {
    
}
