package com.growworth.gotofpatent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "answer")
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column(name = "original_file")
    private String originalFile;

    @Column(name = "created_file")
    private String createdFile;

    // Define the relationship with the answer entity
    @ManyToOne
    @JoinColumn(name = "answer_id")
    @JsonIgnore
    private Answer answer;

}
