package ru.gp.client;

import org.fusesource.restygwt.client.*;
import ru.gp.shared.Article;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;

public interface ArticleService extends RestService {
    @GET
    @Path(value = "http://127.0.0.1:8080/articles")
    public void getAll(MethodCallback<List<Article>> callback);
}