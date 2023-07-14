package com.growworth.gotofpatent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequestDto2 {
    private Long questionnaireId;
    private String category;
    private String name;
    private String phoneNumber;
    private String email;
    private List<FileResponseDto> files;
    private List<QuestionResponseDto2> responses;
}
