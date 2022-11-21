package com.example.techinterviewprep.question;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public QuestionDTO findQuestionById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return QuestionDTO.builder().id(question.getId()).title(question.getTitle()).type(question.getType()).build();
    }

    public Question create(QuestionDTO question) {
        Question savedQuestion = Question.builder().title(question.getTitle()).type(question.getType()).build();
        return questionRepository.save(savedQuestion);
    }
}
