package com.growworth.gotofpatent.repository;

import com.growworth.gotofpatent.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>  {
    List<Question> findByQuestionnaireId(Long questionnaireId);

}
