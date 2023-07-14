package com.growworth.gotofpatent.controller;

import com.growworth.gotofpatent.dto.QuestionResponseDto;
import com.growworth.gotofpatent.entity.Question;
import com.growworth.gotofpatent.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question" )
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @GetMapping("/{questionnaire}")
    public ResponseEntity<List<QuestionResponseDto>> getQuestionsByQuestionnaire(@PathVariable Long questionnaire) {
        List<Question> questions = questionRepository.findByQuestionnaireId(questionnaire);
        List<QuestionResponseDto> responseList = new ArrayList<>();

        for (Question question : questions) {
            QuestionResponseDto responseDto = new QuestionResponseDto();
            responseDto.setId(question.getId());
            responseDto.setSubContent(question.getSubContent());
            responseDto.setType(question.getType());
            responseDto.setContent(question.getContent());
            responseDto.setOrder(question.getQuestionOrder());
            responseDto.setQuestionnaireId(question.getQuestionnaire().getId());

            responseList.add(responseDto);
        }

        if (responseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(responseList);
    }
}
