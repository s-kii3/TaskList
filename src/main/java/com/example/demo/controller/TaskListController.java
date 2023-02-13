package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.TaskItem;
import com.example.demo.service.TaskListService;

@Controller
public class TaskListController {

	private final TaskListService taskListService;

	TaskListController(TaskListService taskListService) {
		this.taskListService = taskListService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<TaskItem> taskItems = taskListService.findAll();
		model.addAttribute("taskList", taskItems);
		return "home";
	}
	
	@GetMapping("/addItem")
	public String addItem(@RequestParam("task") String task, @RequestParam("deadLine") String deadLine) {
		taskListService.add(task, deadLine);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteItem(@RequestParam("id") String id) {
		taskListService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateItem(@RequestParam("id") String id, 
			@RequestParam("task") String task, 
			@RequestParam("deadLine") String deadLine, 
			@RequestParam("done") boolean done) {
		TaskItem item = new TaskItem(id, task, deadLine, done);
		taskListService.update(item);
		return "redirect:/";
	}
}
