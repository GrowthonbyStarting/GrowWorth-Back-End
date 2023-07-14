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
@Entity
@Table(name = "attorney")
public class Attorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attorney_id")
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

    @Column(name = "education", columnDefinition = "TEXT")
    private String education;

    @Column(name = "experience", columnDefinition = "TEXT")
    private String experience;

    @Column(name = "introduction", columnDefinition = "TEXT")
    private String introduction;

    @Column(name = "type")
    private String type;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    // Constructors, getters, and setters
}