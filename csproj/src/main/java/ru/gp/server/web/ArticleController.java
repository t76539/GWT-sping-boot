package ru.gp.server.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gp.shared.Article;

@RestController
@RequestMapping("/rest/todos")
public class TodoController {
	
	final static Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	List<Article> articleList = new ArrayList<>();
	
	public TodoController(){
		articleList.add(new Article("1","Name#1","Descr#1"));
		articleList.add(new Article("2","Name#2","Descr#2"));
		articleList.add(new Article("3","Name#3","Descr#3"));
		articleList.add(new Article("4","Name#4","Descr#4"));
		articleList.add(new Article("5","Name#5","Descr#5"));
	}

	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Article> all() {
        return articleList;
    }
}
