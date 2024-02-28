package com.chungtau.springboottemplate.entity.role;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.user.User;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true) 
@Entity
@Table(name = "roles")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends BaseEntity{
    private static final long serialVersionUID = -32038570L;

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;
}
