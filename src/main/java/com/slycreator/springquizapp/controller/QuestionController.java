package com.slycreator.springquizapp.controller;

import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.Impl.QuestionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionServiceImpl questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public AppResponse fetchQuestions(){
        return this.questionService.fetchQuestion();
    }
}
