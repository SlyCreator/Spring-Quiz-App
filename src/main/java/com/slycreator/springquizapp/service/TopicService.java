package com.slycreator.springquizapp.service;

import com.slycreator.springquizapp.entity.Topic;
import com.slycreator.springquizapp.response.AppResponse;

public interface TopicService {
    AppResponse create(Topic topic);

    AppResponse fetchAll();

    AppResponse fetchOne(Integer integer);

    AppResponse edit(Topic topic, Integer integer);

    AppResponse delete(Integer integer);
}
