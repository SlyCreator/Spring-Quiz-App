package com.slycreator.springquizapp.service;

import com.slycreator.springquizapp.dto.QuestionVO;
import com.slycreator.springquizapp.dto.QuizVO;
import com.slycreator.springquizapp.response.AppResponse;

public interface QuizService {
    public AppResponse submitQuiz(QuizVO quizVO);
}
