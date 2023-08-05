package com.prodius.module4.lesson29hw.servlets;

import com.prodius.module4.lesson29hw.model.Task;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TaskServlets", value = "/task")
public class TaskServlets extends HttpServlet {

    private Task task;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        task = new Task("default");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Enter doGet");

        // здесь мы уже начинаем работать с адресной строкой. в ссылке <i>"bot?action=update"</i>
        // после вопросительного знака идут пары ключ-значение, разделённые знаком &. у нас есть пара action=update.
        // Вызываем значение (параметр) по ключу action, у нас это update и заносим результат в String.
        String action = request.getParameter("action");

        // загодя вносим в запрос атрибут, при исполнении сервлета он будет отправлен в целевую строку. атрибут вносится
        // вместе с ключом. в нашем случае, мы вносим объект bot со всеми его полями как атрибут и задаём ключ "bot",
        // по которому мы потом вызовем данные объекта в jsp-странице
        request.setAttribute("task", task);

        switch (action == null ? "info" : action) {
            /// если параметр имеет значение update (action=update), мы отправляемся на строку /update.jsp, где будем
            // изменять данные бота (и отправляем туда атрибут bot)
            case "update" -> request.getRequestDispatcher("/update.jsp").forward(request, response);
            // если параметр пустой (action == null ? "info"), отправляемся на страницу bot.jsp, где мы увидим данные
            case "info" -> request.getRequestDispatcher("/task.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Enter doPost");

        // правилом хорошего кода будет задать кодировку UTF-8 — в метод могут приходить параметры, скажем, на кириллице
        // (опять же, мы можем дать нашему боту кириллическое имя)
        request.setCharacterEncoding("UTF-8");

        // извлекаем значение параметра action и сохраняем в String, как мы это делали в методе doGet()
        String action = request.getParameter("action");

        // если action=submit, назначаем нашему боту новые значения, которые мы получили в метод. это делается также,
        // извлекая параметры. у каждого параметра из формы есть своё имя, по этому имени мы извлекаем значение
        // (например, в разбираемой выше строчке формы update.jsp name="id" value=${bot.id} мы задаём нашему боту
        // новый id, извлекая его в строчке bot.setId(Integer.parseInt(request.getParameter("id")));
        if ("submit".equals(action)) {
            task.setName(request.getParameter("name"));
        }

        // опять запихиваем объект bot в атрибут и возвращаемся на страницу /bot.jsp, где наблюдаем изменения
        request.setAttribute("task", task);
//        request.getRequestDispatcher("/task.jsp").forward(request, response);
        System.out.println("123");
    }
}