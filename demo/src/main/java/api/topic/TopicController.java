package api.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class TopicController {

		@Autowired
		private TopicService topicservice;
		
		// Get
		@RequestMapping("/topics")
		// Returning Topic objects in List Type
		public List<Topic> getAllTopics() {
			// Here to connect 
			return topicservice.getAllTopics();
		}
		
		// Get
		@RequestMapping("/topics/{id}")
		public Topic getTopic(@PathVariable String id) {
			return topicservice.getTopic(id);
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/topics")
		public void addTopic(@RequestBody Topic topic) {
			topicservice.addTopic(topic);
			
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
		public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
			topicservice.updateTopic(id, topic);
			
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
		public void deleteTopic(@PathVariable String id) {
			topicservice.deleteTopic(id);
			
		}
}
