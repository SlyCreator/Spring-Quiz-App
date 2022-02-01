package com.slycreator.springquizapp.service;

import com.slycreator.springquizapp.dto.QuestionVO;
import com.slycreator.springquizapp.entity.User;
import com.slycreator.springquizapp.response.AppResponse;

public interface QuestionService {
   AppResponse saveQuestion(QuestionVO questionVO);
}

