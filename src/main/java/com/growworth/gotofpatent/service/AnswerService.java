package com.growworth.gotofpatent.service;

import com.growworth.gotofpatent.dto.AnswerRequestDto;
import com.growworth.gotofpatent.entity.Answer;
import com.growworth.gotofpatent.entity.Questionnaire;
import com.growworth.gotofpatent.entity.User;
import com.growworth.gotofpatent.repository.AnswerRepository;
import com.growworth.gotofpatent.repository.QuestionnaireRepository;
import com.growworth.gotofpatent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AnswerService {
   @Autowired
   AnswerRepository answerRepository;
    @Autowired QuestionnaireRepository questionnaireRepository;
    @Autowired UserRepository userRepository;


    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Optional<Answer> getAnswerById(Long answerId) {
        return answerRepository.findById(answerId);
    }

    public Answer createAnswer(AnswerRequestDto answerRequestDto) {
        Questionnaire questionnaire = questionnaireRepository.findById(answerRequestDto.getQuestionnaireId())
                .orElseThrow(() -> new NoSuchElementException("Questionnaire not found"));

        User user = userRepository.findById(answerRequestDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Answer answer = new Answer();
        answer.setQuestionnaire(questionnaire);
        answer.setUserId(user.getId());
        answer.setCategory(answerRequestDto.getCategory());
        answerRepository.save(answer);
        return answerRepository.save(answer);
    }
}
