package lv.acc.api.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lv.acc.api.topic.Topic;

@Entity
public class Course {
	
	@Id
	private String id;
	private String description;
	private String name;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(String id, String description, String name, String topicId) {
		super();
		
		this.id = id;
		this.description = description;
		this.name = name;
		this.topic = new Topic(topicId, "", "");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
