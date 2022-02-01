package com.slycreator.springquizapp;

import com.slycreator.springquizapp.entity.Option;
import com.slycreator.springquizapp.entity.Question;
import com.slycreator.springquizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringQuizAppApplication {
    @Autowired
    private QuestionRepository questionRepository;

    @PostConstruct
    public void initQuestion(){
        for (int i = 1;i<=10;i++){
        Question question = new Question();
        question.setQuestion("what of this is a datatype");

        List<Option> options = new ArrayList<>();

        Option option1 = new Option();
        option1.setOption("Loop");
        option1.setQuestion(question);
        options.add(option1);


        Option option2 = new Option();
        option2.setQuestion(question);
        option2.setOption("Class");
        options.add(option2);

        Option option3 = new Option();
        option3.setOption("LinkedList");
        option3.setQuestion(question);
        option3.setCorrect(true);
        options.add(option3);

        Option option4 = new Option();
        option4.setOption("Method");
        option4.setQuestion(question);
        options.add(option4);

        question.setOptions(options);

            questionRepository.save(question);
        }
    }
//    private PasswordEncoder passwordEncoder;
    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringQuizAppApplication.class, args);
    }

}
