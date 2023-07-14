package com.growworth.gotofpatent.repository;

import com.growworth.gotofpatent.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>  {
    List<Questionnaire> findAll();

}
