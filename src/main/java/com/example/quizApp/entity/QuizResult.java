package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "quiz_result")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_result_id")
    private int quizResultId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "choice_id")
    private Choice choice;

    @Column(name = "order_num")
    private Integer order;

    @Column(name = "is_marked")
    private Byte isMarked;
}
