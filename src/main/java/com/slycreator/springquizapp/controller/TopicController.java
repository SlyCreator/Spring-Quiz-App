package com.slycreator.springquizapp.controller;

import com.slycreator.springquizapp.entity.Topic;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.Impl.TopicServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topics")
public class TopicController {
    private final TopicServiceImpl topicService;

    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public AppResponse createTopic(@RequestBody Topic topic)
    {
        return this.topicService.create(topic);
    }
    @GetMapping
    public AppResponse fetchAllTopics()
    {
        return this.topicService.fetchAll();
    }
    @GetMapping("{/id}")
    public AppResponse fetchOneTopic(@PathVariable Integer integer)
    {
        return this.topicService.fetchOne(integer);
    }
    @PatchMapping("{/id}")
    public AppResponse updateTopic(@PathVariable Integer id,@RequestBody Topic topic)
    {
        return this.topicService.edit(topic,id);
    }
    @DeleteMapping("{/id}")
    public AppResponse deleteTopic(@PathVariable Integer id)
    {
        return this.topicService.delete(id);
    }
}
