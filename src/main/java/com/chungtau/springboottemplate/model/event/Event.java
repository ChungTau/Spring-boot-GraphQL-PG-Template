package com.chungtau.springboottemplate.model.event;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.chungtau.springboottemplate.model.user.User;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Event implements Serializable {
    private static final long serialVersionUID = -1015075218L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String title;

    private String description;

    private String date;

    private String location;

    @ManyToOne
    private User host;

    @ManyToMany(mappedBy = "events")
    private List<User> participants;
}
