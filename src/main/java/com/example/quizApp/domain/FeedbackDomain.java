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
    public String type;
    public Integer rating;
    public String review;
}
