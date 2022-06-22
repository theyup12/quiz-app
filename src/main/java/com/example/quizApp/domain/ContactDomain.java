package com.example.quizApp.domain;

import lombok.*;

@Data
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDomain {
    public String firstName;
    public String lastName;
    public String email;
    public String message;
}
