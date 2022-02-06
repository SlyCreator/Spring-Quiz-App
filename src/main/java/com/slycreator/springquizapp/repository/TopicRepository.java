package com.slycreator.springquizapp.repository;

import com.slycreator.springquizapp.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {
}
