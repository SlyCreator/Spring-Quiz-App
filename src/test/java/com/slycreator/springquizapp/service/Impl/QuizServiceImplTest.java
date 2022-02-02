package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.repository.QuizRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
class QuizServiceImplTest {
    private final QuizServiceImpl quizService;

    QuizServiceImplTest(QuizServiceImpl quizService) {
        this.quizService = quizService;
    }
    @MockBean
    private QuizRepository repository;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}