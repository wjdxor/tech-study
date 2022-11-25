package com.example.techinterviewprep.answer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        Answer saved = answerService.createAnswer(answer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        return ResponseEntity.ok(answerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Answer> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.findOne(id));
    }
}
