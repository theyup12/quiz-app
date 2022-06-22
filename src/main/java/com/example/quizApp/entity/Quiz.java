package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name="quiz_name")
    private User user;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_time")
    private String endTime;
}
