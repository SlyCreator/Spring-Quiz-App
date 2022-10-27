package com.slycreator.springquizapp.controller;

import com.slycreator.springquizapp.dto.QuizVO;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.Impl.QuizServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizServiceImpl quizService;

    public QuizController(QuizServiceImpl quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public AppResponse submitQuiz(@RequestBody QuizVO quizVO) {
        return this.quizService.submitQuiz(quizVO);
    }
}
