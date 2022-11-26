package com.example.techinterviewprep.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AnswerDTO {
    private Long id;
    private String content;
    private Long questionId;

    protected AnswerDTO() {
        /*no option*/
    }
}
