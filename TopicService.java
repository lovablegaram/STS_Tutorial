package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRespository;
	
	private List<Topics> topics = new ArrayList<Topics>(Arrays.asList(
			new Topics("id", "name", "desc"), new Topics("id2", "name2", "desc2")
			));
	
	public List<Topics> getAllTopics(){
		topicRespository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topics getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topics topic) {
		topicRespository.save(topic);
		
	}

}
