package com.slycreator.springquizapp.service;

import com.slycreator.springquizapp.dto.QuestionVO;
import com.slycreator.springquizapp.entity.Topic;
import com.slycreator.springquizapp.entity.User;
import com.slycreator.springquizapp.response.AppResponse;

public interface QuestionService {
   AppResponse create(QuestionVO questionVO);
   AppResponse fetchAll();
   AppResponse fetchRandom(Integer integer);
   AppResponse fetchOne(Integer integer);
   AppResponse edit(QuestionVO questionVO,Integer integer);
   AppResponse delete(Integer integer);
}

