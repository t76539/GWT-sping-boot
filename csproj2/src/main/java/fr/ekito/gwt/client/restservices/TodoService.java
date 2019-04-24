package fr.ekito.gwt.client;

import org.fusesource.restygwt.client.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;
import fr.ekito.gwt.common.Todo;

@Path(value = "/rest/todos")
public interface TodoService extends RestService {
    @GET
    void getAll(MethodCallback<List<Todo>> callback);
}