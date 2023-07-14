package com.growworth.gotofpatent.controller;

import com.growworth.gotofpatent.dto.AnswerRequestDto2;
import com.growworth.gotofpatent.dto.FileResponseDto;
import com.growworth.gotofpatent.dto.QuestionResponseDto;
import com.growworth.gotofpatent.dto.QuestionResponseDto2;
import com.growworth.gotofpatent.entity.Answer;
import com.growworth.gotofpatent.entity.Item;
import com.growworth.gotofpatent.entity.Questionnaire;
import com.growworth.gotofpatent.entity.User;
import com.growworth.gotofpatent.repository.*;
import com.growworth.gotofpatent.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.growworth.gotofpatent.entity.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long answerId) {
        Optional<Answer> optionalAnswer = answerService.getAnswerById(answerId);

        if (optionalAnswer.isPresent()) {
            Answer answer = optionalAnswer.get();
            return ResponseEntity.ok(answer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveAnswer(@RequestBody AnswerRequestDto2 answerRequestDto) {
        // Extract data from the request
        Long questionnaireId = answerRequestDto.getQuestionnaireId();
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(questionnaireId);
        String category = answerRequestDto.getCategory();
        String name = answerRequestDto.getName();
        String phoneNumber = answerRequestDto.getPhoneNumber();
        String email = answerRequestDto.getEmail();
        List<FileResponseDto> files = answerRequestDto.getFiles();
        List<QuestionResponseDto2> responses = answerRequestDto.getResponses();

        // Create and save the User entity
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);

        // Create and save the Answer entity
        Answer answer = new Answer();
        answer.setQuestionnaire(questionnaire.get());
        answer.setUserId(user.getId());
        answer.setCategory(category);
        answerRepository.save(answer);

        // Save the files and associate them with the answer
        if (files != null && !files.isEmpty()) {
            List<File> fileEntities = new ArrayList<>();
            for (FileResponseDto fileDto : files) {
                File fileEntity = new File();
                fileEntity.setOriginalFile(fileDto.getOriginalFile());
                fileEntity.setCreatedFile(fileDto.getCreatedFile());
                fileEntity.setAnswer(answer);
                fileEntities.add(fileEntity);
            }
            fileRepository.saveAll(fileEntities);
        }

        // Create and save the Item entities
        for (QuestionResponseDto2 response : responses) {
            Item item = new Item();
            item.setAnswer(answer);
            item.setQuestion(response.getQuestion());
            item.setType(response.getType());
            item.setResponse(response.getAnswer());
            item.setQuestionOrder(response.getOrder());
            itemRepository.save(item);
        }

        return ResponseEntity.ok().build();
    }


}
