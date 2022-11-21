package com.example.techinterviewprep.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String title;
    private String type;

    protected QuestionDTO() {
        /*no option*/
    }
}
