package com.example.webapp.helper;

import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;

public class ToDoHelper {
	
	/**
	 * ToDoへの変換
	 */
	public static ToDo convertToDo(ToDoForm form) {
	    ToDo todo = new ToDo();
	    todo.setId(form.getId());
	    todo.setTodo(form.getTodo());
	    todo.setDetail(form.getDetail());
	    todo.setIsCompleted(form.getIsCompleted());
	    todo.setDueDate(form.getDueDate());
	    todo.setCategory(form.getCategory());
	    todo.setDeleteFlag(form.getDeleteFlag());
	    return todo;
	}
	
	/**
	 * ToDoFormへの変換
	 */
	public static ToDoForm convertToDoForm(ToDo todo) {
		ToDoForm form = new ToDoForm();
		form.setId(todo.getId());
		form.setTodo(todo.getTodo());
		form.setDetail(todo.getDetail());
		form.setIsCompleted(todo.getIsCompleted());
		//更新画面設定
		form.setIsNew(false);
		form.setDueDate(todo.getDueDate());
		form.setCategory(todo.getCategory());
		form.setDeleteFlag(todo.getDeleteFlag());
		return form;
	}
	
	

}
