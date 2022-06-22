package com.example.quizApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_description")
    private String description;

    @OneToOne(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Quiz quiz;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private Set<Question> questions = new HashSet<>();
}
