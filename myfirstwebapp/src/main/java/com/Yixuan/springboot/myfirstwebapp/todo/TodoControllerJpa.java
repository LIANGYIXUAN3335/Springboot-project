package com.Yixuan.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoService todoService,TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model){
		String username = getLoggedinUsername(model);
//		todoRepository.getById(null)
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
//		https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html
		return "listTodos";
	}
	private String getLoggedinUsername(ModelMap model){
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	@RequestMapping(value= "add-todo", method = RequestMethod.GET)
	public String showNewTodos(ModelMap model){
		String username = (String)model.get("name");
		Todo todo = new Todo(0,username,"Default desc",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value= "add-todo", method = RequestMethod.POST)
	public String addNewTodos(ModelMap model,@Valid Todo todo,BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedinUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoService.addTodo((String) model.get("name"), todo.getDescription(), 
//				LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	@RequestMapping(value= "delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value= "update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
//		Todo todo = todoService.updateTodoById(id);
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value= "update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
}
