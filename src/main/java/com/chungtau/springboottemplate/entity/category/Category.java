package com.chungtau.springboottemplate.entity.category;
import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.product.Product;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true) 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "categories")
@QueryEntity
public class Category extends BaseEntity {
    private static final long serialVersionUID = -1540430250L;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}