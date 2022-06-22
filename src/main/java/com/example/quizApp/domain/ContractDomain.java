package com.example.quizApp.domain;

import lombok.*;

@Data
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDomain {
    public String firstName;
    public String lastName;
    public String email;
    public String message;
}
