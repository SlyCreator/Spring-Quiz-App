package com.slycreator.springquizapp.repository;

import com.slycreator.springquizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
