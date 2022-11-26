package com.example.techinterviewprep.answer;

import com.example.techinterviewprep.question.Question;
import com.example.techinterviewprep.question.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public AnswerDTO createAnswer(AnswerDTO answerDTO) {
        Question question = questionRepository.findById(answerDTO.getQuestionId()).orElseThrow(
            () -> new IllegalArgumentException("문제가 올바르지 않습니다.")
        );
        Answer save = Answer.builder().content(answerDTO.getContent()).question(question).build();
        answerRepository.save(save);

        return AnswerDTO.builder().id(save.getId()).build();
    }

    public AnswerDTO findOne(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("답변이 없습니다.")
        );
        return AnswerDTO.builder().content(answer.getContent()).questionId(answer.getQuestion().getId()).build();
    }

    public List<AnswerDTO> findAll() {
        return answerRepository.findAll().stream().map(
            x -> AnswerDTO.builder().id(x.getId()).content(x.getContent()).questionId(x.getQuestion().getId()).build()
        ).collect(Collectors.toList());
    }
}
