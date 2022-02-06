package com.slycreator.springquizapp.controller;

import com.slycreator.springquizapp.dto.QuestionVO;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.Impl.QuestionServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionServiceImpl questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public AppResponse fetchQuestions(){
        return this.questionService.fetchAll();
    }
    @GetMapping("/{id}")
    public AppResponse fetchOneQuestion(@PathVariable Integer id){
        return this.questionService.fetchOne(id);
    }
    @GetMapping("quiz")
    public AppResponse fetchRandomly(@RequestBody Integer integer){
        return this.questionService.fetchRandom(integer);
    }

    @PostMapping
    public AppResponse saveQuestion(@RequestBody QuestionVO questionVO){
        return this.questionService.create(questionVO);
    }

    @PatchMapping("/{id}")
    public AppResponse editQuestion(@RequestBody QuestionVO questionVO,@PathVariable Integer id){
        return this.questionService.edit(questionVO,id);
    }

    @DeleteMapping("/{id}")
    public AppResponse deleteQuestion(@PathVariable Integer id){
        return this.questionService.delete(id);
    }
}
