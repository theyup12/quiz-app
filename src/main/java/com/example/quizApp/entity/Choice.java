package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "choice")
public class Choice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private int choiceId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "option_content")
    private String contents;

    @Column(name = "is_correct")
    private Byte isCorrect;
}
