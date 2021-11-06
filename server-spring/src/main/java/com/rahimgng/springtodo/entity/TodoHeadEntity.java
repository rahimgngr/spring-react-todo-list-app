package com.rahimgng.springtodo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "header")
public class TodoHeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long titleId;
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "todoHeadEntity")
    private List<TodoSubEntity> todoSubEntities;
}
