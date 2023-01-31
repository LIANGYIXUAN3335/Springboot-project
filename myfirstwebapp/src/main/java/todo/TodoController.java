package todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService todoService;
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model){
		List<Todo> todos = todoService.findByUsername("yixuan");
		
		model.addAttribute("todos", todos);
//		https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html
		return "listTodos";
	}
	@RequestMapping(value= "add-todo", method = RequestMethod.GET)
	public String showNewTodos(){
		return "todo";
	}
	
	@RequestMapping(value= "add-todo", method = RequestMethod.POST)
	public String addNewTodos(@RequestParam String description,ModelMap model){
		todoService.addTodo((String) model.get("name"), description, 
				LocalDate.now(), false);
		return "redirect:list-todos";
	}
}
