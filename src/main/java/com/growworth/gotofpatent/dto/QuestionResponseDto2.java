package com.growworth.gotofpatent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto2 {
    private String question;
    private String Type;
    private String answer;
    private Long order;

}
