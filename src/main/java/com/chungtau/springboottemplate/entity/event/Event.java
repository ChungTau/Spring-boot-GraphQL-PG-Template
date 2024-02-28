package com.chungtau.springboottemplate.entity.event;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.user.User;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "events")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Event extends BaseEntity {
    private static final long serialVersionUID = -1015075218L;

    private String title;

    private String description;

    private String date;

    private String location;

    @ManyToOne
    private User host;

    @ManyToMany(mappedBy = "events")
    private List<User> participants;
}
