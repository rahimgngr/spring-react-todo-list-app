package com.rahimgng.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task")
public class TodoSubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long taskId;
    @Column(name = "title_id")
    private Long titleId;
    private String task;
    private boolean completed;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id", nullable = false, insertable = false, updatable = false)
    private TodoHeadEntity todoHeadEntity;

}
