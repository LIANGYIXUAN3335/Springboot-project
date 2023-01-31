package todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class TodoService {
	private static int todoCount = 0;
	private static List<Todo> todos = new ArrayList();
	static {
		todos.add(new Todo(++todoCount,"yixuan","learnSpring",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"yixuan","learnSpringboot",
				LocalDate.now().plusYears(1),false));

	}
	public List<Todo> findByUsername(String username){
		return todos;
	}
	public void addTodo(String username,String description,LocalDate targetdate, boolean done) {
		Todo todo  = new Todo(++todoCount,username,description,targetdate,done);
		todos.add(todo);
	
	}
}
