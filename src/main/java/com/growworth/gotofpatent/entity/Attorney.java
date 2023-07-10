package com.growworth.gotofpatent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attorney")
@Table(name = "attorney")
public class Attorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attorneyId;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @Column
    private String attorneyName;

    @Column(columnDefinition = "TEXT")
    private String education;

    @Column(columnDefinition = "TEXT")
    private String experience;

    @Column(columnDefinition = "TEXT")
    private String introduction;

    @Column
    private String type;

    @Column
    private String attorneyEmail;

    @Column
    private String attorneyPhoneNumber;


}
