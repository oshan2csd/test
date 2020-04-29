package javabrains.springboot.courseapidata.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * Controller methods in this class
 * GET       /topics         Gets all topics
 * GET       /topics/id      Gets the specific topic
 * POST      /topics         Create a new topic
 * PUT       /topics/id      Updates the topic
 * DELETE    /topics/id      Delete the topic
 *
 * */

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    //Get all topics as a list
    //By default @Requestmapping is equal to @Getmapping
    //Can use either way
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return  topicService.getAllTopics();
    }

    //get a specific topic
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id){

        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable("id") String id){

        topicService.deleteTopic(id);


    }


}
