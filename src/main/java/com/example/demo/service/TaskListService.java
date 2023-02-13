package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskItem;
import com.example.demo.repository.TaskItemRepository;

@Service
public class TaskListService {

	@Autowired
	private TaskItemRepository taskItemRepository;
	
	public List<TaskItem> findAll() {
        return taskItemRepository.findAll();
    }
	
	public void add(String task, String deadLine) {
		String id = UUID.randomUUID().toString().substring(0, 8);
		TaskItem item = new TaskItem(id, task, deadLine, false);
		taskItemRepository.add(item);
    }
	
	public void delete(String id) {
		taskItemRepository.delete(id);
    }
	
	public void update(TaskItem taskItem) {
		taskItemRepository.update(taskItem);
    }
}
