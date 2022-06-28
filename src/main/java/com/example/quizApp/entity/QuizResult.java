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

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name="user_choice")
    private Integer userChoice;

    @Column(name="correct_choice")
    private Integer correctChoice;

    @Column(name = "order_num")
    private Integer order;

    @Column(name = "is_marked")
    private Byte isMarked;
}
