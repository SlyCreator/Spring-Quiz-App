package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.dto.QuestionVO;
import com.slycreator.springquizapp.entity.Question;
import com.slycreator.springquizapp.repository.QuestionRepository;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public AppResponse saveQuestion(QuestionVO questionVO) {
        return null;
    }

    public AppResponse fetchQuestion(){
        Page<Question> questions = questionRepository.findAll(Pageable.ofSize(5));
        Map<String,Object> map = new HashMap<>();
        map.put("questions",questions);
        return AppResponse.ok().data(map).message("questions and answer retrieved successfully");
    }
}
