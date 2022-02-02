package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.entity.Question;
import com.slycreator.springquizapp.repository.QuestionRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
public class QuestionServiceImplIntegrationTest {
    @Before
    public void setUp(){
        List<Question> questions = new ArrayList<>();
        for (int i = 1;i<=10;i++) {
            Question question = new Question();
            question.setQuestion("Question"+i);
            questions.add(question);
            questionRepository.save(question);
        }
       // Mockito.when(questionRepository.findAll(Pageable.ofSize(5)).stream().count());

    }
    private QuestionServiceImpl questionService;

    @MockBean
    private QuestionRepository questionRepository;

    @Test
    public void getQuestion(){
            assertEquals(10,questionService.fetchQuestion().getData().size());
    }
}