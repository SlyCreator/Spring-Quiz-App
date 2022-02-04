package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.dto.QuestionVO;
import com.slycreator.springquizapp.entity.Option;
import com.slycreator.springquizapp.entity.Question;
import com.slycreator.springquizapp.entity.Topic;
import com.slycreator.springquizapp.repository.QuestionRepository;
import com.slycreator.springquizapp.repository.TopicRepository;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, TopicRepository topicRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public AppResponse create(QuestionVO questionVO) {
            Question question = new Question();
            question.setQuestion(questionVO.getQuestion());
          //  question.setTopicId(questionVO.getTopicId());
            List<Option> optionVOList = questionVO.getOptions();

            /**commit the options**/
            List<Option> options = new ArrayList<>();
            optionVOList.stream().forEach((optionvo) ->{
                Option option = new Option();
                option.setOption(optionvo.getOption());
                option.setQuestion(question);
                options.add(option);
            });

            question.setOptions(options);
            questionRepository.save(question);
        Map<String,Object> map = new HashMap<>();
        map.put("question",question);
        return AppResponse.ok().data(map).message("questions and answer retrieved successfully");
    }

    @Override
    public AppResponse fetchAll() {
        Page<Question> questions = questionRepository.findAll(Pageable.ofSize(10));
        Map<String,Object> map = new HashMap<>();
        map.put("questions",questions);
        return AppResponse.ok().data(map).message("questions and answer retrieved successfully");
    }

    @Override
    public AppResponse fetchRandom(Integer integer) {
        Page<Question> questions = questionRepository.findAll(Pageable.ofSize(integer));
        Map<String,Object> map = new HashMap<>();
        map.put("questions",questions);
        return AppResponse.ok().data(map).message("questions and answer retrieved successfully");
    }

    @Override
    public AppResponse fetchOne(Integer integer) {
        Optional<Question> question = questionRepository.findById(integer);
        Map<String,Object> map = new HashMap<>();
        map.put("questions",question);
        return AppResponse.ok().data(map).message("questions and answer retrieved successfully");
    }

    @Override
    public AppResponse edit(QuestionVO questionVO, Integer integer) {
        return null;
    }

    @Override
    public AppResponse delete(Integer integer) {
        questionRepository.deleteById(integer);
        Map<String, Object> map = new HashMap<>();
        return AppResponse.ok().code(204)
                .data(map).message("deleted successfully");
    }
}
