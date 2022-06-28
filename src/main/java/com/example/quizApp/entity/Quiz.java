package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private int quizId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    @Column(name="start_time")
    private String startTime;

    @Column(name="finish_time")
    private String finishTime;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private Set<QuizResult> quizResults = new HashSet<>();
}
