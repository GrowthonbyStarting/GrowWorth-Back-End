package com.growworth.gotofpatent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedChoiceDto {
    private Long questionId;
    private String selectedChoice;
}
