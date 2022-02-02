package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.dto.QuizVO;
import com.slycreator.springquizapp.entity.Option;
import com.slycreator.springquizapp.entity.Quiz;
import com.slycreator.springquizapp.entity.QuizAnswer;
import com.slycreator.springquizapp.entity.User;
import com.slycreator.springquizapp.repository.OptionRepository;
import com.slycreator.springquizapp.repository.QuizRepository;
import com.slycreator.springquizapp.repository.UserRepository;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.QuizService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final OptionRepository optionRepository;
    private final UserServiceImpl userService;

    public QuizServiceImpl(QuizRepository quizRepository,
                           OptionRepository optionRepository,
                           UserServiceImpl userService) {
        this.quizRepository = quizRepository;
        this.optionRepository = optionRepository;
        this.userService = userService;
    }

    @Transactional
    @Override
    public AppResponse submitQuiz(QuizVO quizVO) {

      List<Integer> list = Arrays.stream(quizVO.getAnswers()).boxed().collect(Collectors.toList());
      List<Option> optionList = optionRepository.findAllByIdIn(list);

        AtomicInteger score = new AtomicInteger();
        Quiz quiz = new Quiz();
        User user = userService.AuthUser();
        quiz.setUser(user);


        List<QuizAnswer> quizAnswers = new ArrayList<>();
        optionList.stream().forEach((option)->{
            boolean isCorrect = false;
            if (option.isCorrect() == true){
                isCorrect = true;
                score.getAndIncrement();
            }
            QuizAnswer quizAnswer = new QuizAnswer();
            quizAnswer.setQuiz(quiz);
            quizAnswer.setQuestionId(option.getQuestion().getId());
            quizAnswer.setOptionId(option.getId());
            quizAnswer.setCorrect(isCorrect);
            quizAnswers.add(quizAnswer);

        });
        quiz.setScore(score.intValue());
        quiz.setQuizAnswers(quizAnswers);
        quizRepository.save(quiz);
        Map<String,Object> map = new HashMap<>();
        map.put("result",quiz);
        return AppResponse.ok().data(map).message("Quiz Submitted successfully");
    }
}
