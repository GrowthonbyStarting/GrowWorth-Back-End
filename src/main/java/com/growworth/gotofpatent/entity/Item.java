package com.growworth.gotofpatent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "answer")
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(name = "question")
    private String question;

    @Column(name = "type")
    private String type;

    @Column(name = "response", columnDefinition = "TEXT")
    private String response;

    @Column(name = "question_order")
    private Long QuestionOrder;


}
