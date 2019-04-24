package ru.gp.client.restservices;

import org.fusesource.restygwt.client.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;
import ru.gp.common.Todo;

@Path("/todos")
public interface TodoService extends RestService {
    @GET
    void getAll(MethodCallback<List<Todo>> callback);
}