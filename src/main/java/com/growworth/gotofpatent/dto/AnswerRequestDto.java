package com.growworth.gotofpatent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequestDto {
    private Long questionnaireId;
    private Long userId;
    private String category;

}
