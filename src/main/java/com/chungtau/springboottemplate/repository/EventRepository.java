package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.model.event.Event;

@GraphQlRepository
public interface EventRepository extends CrudRepository<Event, String>, QuerydslPredicateExecutor<Event>  {
    
}
