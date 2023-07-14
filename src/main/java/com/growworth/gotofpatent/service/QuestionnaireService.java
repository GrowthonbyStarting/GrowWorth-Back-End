package com.growworth.gotofpatent.service;

import com.growworth.gotofpatent.entity.Questionnaire;
import com.growworth.gotofpatent.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> findAll() {
        System.out.println(questionnaireRepository.findAll());
        return questionnaireRepository.findAll();
    }
}
