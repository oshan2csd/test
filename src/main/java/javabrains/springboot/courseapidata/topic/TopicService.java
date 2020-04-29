package javabrains.springboot.courseapidata.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics =  new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring framework Description"),
                new Topic(".Net", ".Net Framework", ".Net framework Description"),
                new Topic("Python", "Python 3", "Python Description")
    ));


    //returns a list
    //Spring MVC framework will convert it into a jason object
    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().toLowerCase().equals(id.toLowerCase())).findFirst().get();
    }


    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {

        //Using Lambda expression
        /*
        topics.stream().filter(t -> t.getId().toLowerCase().equals(id.toLowerCase()))
        .forEach( f -> {
                    f.setName(topic.getName());
                    f.setDescription(topic.getDescription());
        }
        );
        */

        //using a for loop
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
