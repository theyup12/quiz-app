package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer user_id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "is_active")
    private Byte isActive;

    @Column(name = "is_admin")
    private Byte isAdmin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private Set<Quiz> quizzes;
}
