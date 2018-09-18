package lv.acc.api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	Logger logger = LoggerFactory.getLogger(TopicService.class);
	
	@Autowired
	private TopicRepository topicRepository;
	
//	List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("spring", "Spring Framework", "Cool description"),
//			new Topic("java", "Java Framework ", "Java description"),
//			new Topic("javascript", "Javascript Framework", "Javascript description")));

	public List<Topic> getAllTopics() {
		logger.info("getAllTopics executed");
		//return topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Topic> res =  topicRepository.findById(id);
		return res.isPresent() ? res.get() : null;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);

	}

	public void updateTopic(Topic topic, String id) {
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				logger.info("updated topic with Id: " + id);
//				return;
//			}
//		}
		
		topicRepository.save(topic);

	}

	public void deleteTopic(String id) {
//		Predicate<Topic> topicDeletePredicate = (Topic t) -> {
//			if (t.getId().equals(id)) {
//				logger.info("removing topic with Id: " + id);
//				return true;
//			}
//			return false;
//		};
//		topics.removeIf(topicDeletePredicate);
		topicRepository.deleteById(id);

	}
}
