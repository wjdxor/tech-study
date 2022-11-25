package com.example.techinterviewprep.answer;

import com.example.techinterviewprep.question.Question;
import com.example.techinterviewprep.question.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(Answer answer) {
        Question question = questionRepository.findById(answer.getId()).orElseThrow(
            () -> new IllegalArgumentException("문제가 올바르지 않습니다.")
        );

        return Answer.builder()
            .question(question)
            .content(answer.getContent())
            .build();
    }

    public Answer findOne(Long id) {
        return answerRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("답변이 없습니다.")
        );
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }
}
