package ms.edu.utez.firstapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ms.edu.utez.firstapp.models.user.DaoUser;
import ms.edu.utez.firstapp.models.user.User;

import java.io.IOException;
import java.util.List;

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
    req.setCharacterEncoding("UTF-8");
    action=req.getServletPath();
    //el metodo manda traer la ultima lineas del URL
        switch (action){
            case"/user/users":
                List<User> users = new DaoUser().findAll();
                req.setAttribute("users",users);
                redirect = "/views/user/index.jsp";
                break;
            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
