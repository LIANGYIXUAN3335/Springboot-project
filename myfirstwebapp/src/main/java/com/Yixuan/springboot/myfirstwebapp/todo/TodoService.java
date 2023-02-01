package com.Yixuan.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
	private static int todoCount = 0;
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo(++todoCount,"yixuan","learnSpring",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"yixuan","learnSpringboot",
				LocalDate.now().plusYears(1),false));

	}
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate=todo -> todo.getUsername().equals(username);

		return todos.stream().filter(predicate).toList();
	}
	public void addTodo(String username,String description,LocalDate targetdate, boolean done) {
		Todo todo  = new Todo(++todoCount,username,description,targetdate,done);
		todos.add(todo);
	
	}
	public void deleteTodoById(int id) {
		Predicate<? super Todo> predicate=todo -> todo.getId() ==id;
		todos.removeIf(predicate);
	}

	public Todo updateTodoById(@Valid Todo todo ) {
		// TODO Auto-generated method stub
		deleteTodoById(todo.getId());
		todos.add(todo);
		return todo;
	}
	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo -> todo.getId() ==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
		// TODO Auto-generated method stub

}
