package com.growworth.gotofpatent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "item")
@Entity(name = "answer")
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category")
    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "answer_id")
    @JsonIgnore
    private List<File> files;
}
