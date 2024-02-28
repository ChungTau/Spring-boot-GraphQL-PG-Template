package com.chungtau.springboottemplate.entity.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.product.Product;
import com.chungtau.springboottemplate.entity.user.User;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true) 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "reviews")
@QueryEntity
public class Review extends BaseEntity {
    private static final long serialVersionUID = -1994238698L;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private int rating;

    private String comment;
}