package com.growworth.gotofpatent.controller;

import com.growworth.gotofpatent.entity.Questionnaire;
import com.growworth.gotofpatent.repository.QuestionnaireRepository;
import com.growworth.gotofpatent.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire" )
public class QuestionnaireController {
    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @GetMapping("")
    public ResponseEntity getQuestionnaire() {
        System.out.println("questionnaireService.findAll() = " + questionnaireService.findAll());
        List<Questionnaire> questionnaireList = questionnaireService.findAll();

        return new ResponseEntity(questionnaireList, HttpStatus.OK);


    }
}

