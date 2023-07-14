package com.growworth.gotofpatent.dto;

import com.growworth.gotofpatent.entity.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedChoiceResponseDto {
    private Long questionId;
    private String questionContent;
    private List<OptionDto> option;
}
