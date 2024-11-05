package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TaskItem;
import com.example.demo.service.TaskListService;

@RestController
@RequestMapping({"/api/tasks", "/api/tasks/"})
@CrossOrigin(origins = "http://localhost:3000")
public class TaskListApiController {

	private final TaskListService taskListService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	TaskListApiController(TaskListService taskListService) {
		this.taskListService = taskListService;
	}
	
	@GetMapping
	public ResponseEntity<List<TaskItem>> getItem() {
        logger.info("getItem開始");
		List<TaskItem> taskItems = taskListService.findAll();
        logger.info("getItem終了 taskItems:" + taskItems);
		return new ResponseEntity<>(taskItems, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<List<TaskItem>> addItem(@RequestBody TaskItem reqTaskItem) {
        logger.info("addItem開始 taskItem:" + reqTaskItem);
		TaskItem taskItem = taskListService.add(reqTaskItem.getTask(), reqTaskItem.getDeadLine());
        List<TaskItem> taskItems = new ArrayList<>();
        taskItems.add(taskItem);
        logger.info("addItem終了");
		return new ResponseEntity<>(taskItems, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable String id) {
        logger.info("deleteItem開始 id:" + id);
		taskListService.delete(id);
        logger.info("deleteItem終了");
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<String> updateItem(@RequestBody TaskItem reqTaskItem) {
        logger.info("updateItem開始 reqTaskItem:" +reqTaskItem);
		taskListService.update(reqTaskItem);
        logger.info("updateItem終了");
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
