package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.model.user.User;

@GraphQlRepository
public interface UserRepository extends CrudRepository<User, String>, QuerydslPredicateExecutor<User> {
    
}
