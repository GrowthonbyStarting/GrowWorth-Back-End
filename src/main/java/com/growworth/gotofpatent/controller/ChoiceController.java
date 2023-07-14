package com.growworth.gotofpatent.controller;

import com.growworth.gotofpatent.dto.ChoiceResponseDto;
import com.growworth.gotofpatent.entity.Choice;
import com.growworth.gotofpatent.repository.ChoiceRepository;
import com.growworth.gotofpatent.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/choice" )
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private ChoiceRepository choiceRepository;

    @GetMapping("/{questionId}")
    public ResponseEntity<List<ChoiceResponseDto>> getChoicesByQuestionId(@PathVariable Long questionId) {
        List<Choice> choices = choiceRepository.findByQuestionId(questionId);

        List<ChoiceResponseDto> choiceResponseDtos = choices.stream()
                .map(choice -> new ChoiceResponseDto(choice.getId(), choice.getChoiceContent(), choice.getQuestion().getId()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(choiceResponseDtos);
    }
}
