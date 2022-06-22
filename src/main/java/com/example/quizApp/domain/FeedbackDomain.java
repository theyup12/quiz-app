package com.example.quizApp.domain;

import lombok.*;

@Data
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDomain {
    public String review;
    public int rating;
    public String date;
}
