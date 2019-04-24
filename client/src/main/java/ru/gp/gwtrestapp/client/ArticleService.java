package ru.gp.gwtrestapp.client;

import org.fusesource.restygwt.client.*;
import com.google.gwt.http.client.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;
import ru.gp.gwtrestapp.shared.Article;

public interface ArticleService extends RestService {
    @GET
    @Path(value = "http://127.0.0.1:8080/articles")
    public void getAll(MethodCallback<List<Article>> callback);
}