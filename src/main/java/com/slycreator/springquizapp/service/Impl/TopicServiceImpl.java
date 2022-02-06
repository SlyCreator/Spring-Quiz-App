package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.entity.Topic;
import com.slycreator.springquizapp.repository.TopicRepository;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public AppResponse create(Topic topic) {
        topicRepository.save(topic);
        Map<String,Object> map = new HashMap<>();
        map.put("topic",topic);
        return AppResponse.ok().code(201)
                .data(map).message("created successfully");
    }

    @Override
    public AppResponse fetchAll() {
        Page<Topic> topics = topicRepository.findAll(Pageable.ofSize(10));
        Map<String, Object> map = new HashMap<>();
        map.put("topics",topics);
        return AppResponse.ok().code(200)
                .data(map).message("Retrieved successfully");
    }

    @Override
    public AppResponse fetchOne(Integer integer) {
        Optional<Topic> topic = topicRepository.findById(integer);
        Map<String, Object> map = new HashMap<>();
        map.put("topic",topic);
        return AppResponse.ok().code(200)
                .data(map).message("Retrieved successfully");
    }

    @Override
    public AppResponse edit(Topic topic, Integer id) {
        Topic updateTopic = topicRepository.findById(id).orElse(null);
        updateTopic.setTitle(topic.getTitle());
        updateTopic.setDescription(topic.getDescription());
        Map map = new HashMap<>();
        map.put("topic",map);
        return AppResponse.ok().code(200)
                .data(map).message("updated successfully");
    }

    @Override
    public AppResponse delete(Integer integer) {
        topicRepository.deleteById(integer);
        Map<String, Object> map = new HashMap<>();
        return AppResponse.ok().code(204)
                .data(map).message("deleted successfully");
    }
}
