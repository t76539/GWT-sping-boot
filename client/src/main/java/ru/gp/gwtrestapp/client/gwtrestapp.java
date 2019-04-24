package ru.gp.gwtrestapp.client;

import java.util.List;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;

import org.fusesource.restygwt.client.*;
import ru.gp.gwtrestapp.shared.Article;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class gwtrestapp implements EntryPoint {

    final String url = "http://localhost:8080/articles";

    public void onModuleLoad() {

        ArticleService service = GWT.create(ArticleService.class);

        service.getAll(new MethodCallback<List<Article>>() {

            @Override
            public void onFailure(Method method, Throwable exception) {
                HTML html = new HTML("<b>Error:</b><pre>" + exception + "</pre>");
                RootLayoutPanel.get().add(html);
            }

            @Override
            public void onSuccess(Method method, List<Article> response) {
                StringBuilder sb = new StringBuilder("<table border=1>");
                for (Article article : response) {
                    sb.append("<tr><td>");
                    sb.append(article.getId());
                    sb.append("<td>");
                    sb.append(article.getName());
                    sb.append("<td>");
                    sb.append(article.getDescription());
                }
                sb.append("</table>");
                HTML html = new HTML(sb.toString());
                RootLayoutPanel.get().add(html);
            }

        });

    }
}
