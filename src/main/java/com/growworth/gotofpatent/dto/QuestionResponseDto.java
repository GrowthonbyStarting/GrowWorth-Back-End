package com.growworth.gotofpatent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {
    private Long id;
    private String type;
    private String content;
    private String subContent;
    private Long order;
    private Long questionnaireId;
}
