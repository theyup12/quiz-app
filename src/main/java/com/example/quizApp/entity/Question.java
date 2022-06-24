package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "question_content")
    private String content;

    @Column(name = "question_status")
    private String status;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private List<Choice> choices;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private QuizResult quizResult;
}
