package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.model.role.Role;

@GraphQlRepository
public interface RoleRepository extends CrudRepository<Role, String>, QuerydslPredicateExecutor<Role> {
    
}
