package com.kuyajon.learningportal.model.course;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "topics")
@Data
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String content = "";

    @Column(nullable = false)
    private int sortOrder;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Test test;
}
