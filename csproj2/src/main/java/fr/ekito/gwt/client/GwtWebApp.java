package fr.ekito.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
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
		loadTodoList2();
	}

	private void loadTodoList() {
		String pageBaseUrl = GWT.getHostPageBaseURL();
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, pageBaseUrl + "/rest/todos/");
		rb.setCallback(new RequestCallback() {

			public void onError(Request request, Throwable e) {
				// some error handling code here
				Window.alert("error = " + e.getMessage());
			}

			public void onResponseReceived(Request request, Response response) {
				if (200 == response.getStatusCode()) {
					panel.add(new HTML("<pre>" + response.getText() + "</pre>"));
				}
			}
		});
		try {
			rb.send();
		} catch (RequestException e) {
			e.printStackTrace();
			Window.alert("error = " + e.getMessage());
		}
	}

	    final String url = "http://localhost:8080/articles";

    private void loadTodoList2() {

        TodoService service = GWT.create(TodoService.class);

        service.getAll(new MethodCallback<List<Todo>>() {

            @Override
            public void onFailure(Method method, Throwable exception) {
                panel.add(new HTML("<b>Error:</b><pre>" + exception + "</pre>"));
            }

            @Override
            public void onSuccess(Method method, List<Todo> response) {
                StringBuilder sb = new StringBuilder("<table border=1>");
                for (Todo todo : response) {
                    sb.append("<tr><td>");
                    sb.append(todo.getTitle());
                    sb.append("<td>");
                }
                sb.append("</table>");
                panel.add(new HTML(sb.toString()));
            }

        });

    }

}
