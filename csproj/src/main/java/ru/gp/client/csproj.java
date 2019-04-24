package ru.gp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ru.gp.shared.Article;

import java.util.List;

public class csproj implements EntryPoint {

    VerticalPanel panel;
    final String url = "http://localhost:8080/articles";

    public void onModuleLoad() {
        panel = new VerticalPanel();
        RootPanel.get().add(panel);
        panel.add(new HTML("Run gwt project#1"));
        showArticles();
    }

    public void showArticles() {

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
                panel.add(new HTML(sb.toString()));
            }

        });

    }

}
