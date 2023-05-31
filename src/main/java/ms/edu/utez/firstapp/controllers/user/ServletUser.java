package ms.edu.utez.firstapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "users",urlPatterns = {
        "/user/users",
        "/user/user",
        "/user/user-view",
        "/user/save,",
        "/user/user-view-update",
        "/user/update",
        "/user/delate"
})
public class ServletUser extends HttpServlet {
    private  String action;
    private String redirect = "/user/users";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
