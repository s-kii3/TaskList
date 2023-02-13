package com.example.demo.repository;

import com.example.demo.entity.TaskItem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskItemRepository {

	public List<TaskItem> findAll();

    public void  add(TaskItem taskItem);

    public void delete(String id);

    public void  update(TaskItem taskItem);
}
