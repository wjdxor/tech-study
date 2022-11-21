package com.example.techinterviewprep.question;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionDTO {
    private Long id;
    private String title;
    private String type;

    protected QuestionDTO() {
        /*no option*/
    }
}
