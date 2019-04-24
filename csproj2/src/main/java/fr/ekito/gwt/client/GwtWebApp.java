package fr.ekito.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import fr.ekito.gwt.client.restservices.TodoService;
import fr.ekito.gwt.common.Todo;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class GwtWebApp implements EntryPoint {

    VerticalPanel panel = new VerticalPanel();

    public void onModuleLoad() {
        panel.add(new HTML("Run..."));
        RootPanel.get().add(panel);
        loadTodoList();
    }

    private void loadTodoList() {

        TodoService service = GWT.create(TodoService.class);

        service.getAll(new MethodCallback<List<Todo>>() {

            @Override
            public void onFailure(Method method, Throwable exception) {
                panel.add(new HTML("<b>Error:</b><pre>" + exception + "</pre>"));
            }

            @Override
            public void onSuccess(Method method, List<Todo> response) {
                StringBuilder sb = new StringBuilder("<table border=1 cellspacing=0>");
                for (Todo todo : response) {
                    sb.append("<tr><td>");
                    sb.append(todo.getTitle());
                }
                sb.append("</table>");
                panel.add(new HTML(sb.toString()));
            }

        });
    }

}
