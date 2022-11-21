package com.example.techinterviewprep.question;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody QuestionDTO questionDTO) {
        Question question = questionService.create(questionDTO);
        return ResponseEntity.ok(question);
    }

    @GetMapping
    public ResponseEntity<List<Question>> findAll() {
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findQuestionById(id));
    }
}
