package com.kuyajon.learningportal.model.client;

import com.kuyajon.learningportal.model.course.Lesson;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "lesson_progress")
@Data
public class LessonProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(nullable = false)
    private EProgressStatus status = EProgressStatus.NOT_STARTED;

    @Column(nullable = false)
    private boolean hasQuiz;  // Does this lesson has a quiz?

    @Column(nullable = false)
    private boolean quizTaken;  // Track if the quiz was taken

    @Column(nullable = true)
    private Integer score;  // Store the quiz score (nullable)
}
