package com.growworth.gotofpatent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private Long id;

    @Column(name = "choice_content")
    private String choiceContent;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Constructors, getters, and setters
}
