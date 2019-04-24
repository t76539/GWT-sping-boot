package ru.gp.server.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.gp.common.Todo;

@RestController
@RequestMapping("/gwtwebapp/todos")
public class TodoController {
	
	final static Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	List<Todo> todoList = new ArrayList<>();
	
	public TodoController() {
		logger.info("TodoController.TodoController()");
		for (int i=0; i < 10; i++) {
			todoList.add(new Todo("Todo #" + i));
		}
	}

	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> all() {
		logger.info("TodoController.all()");
        return todoList;
    }
}
