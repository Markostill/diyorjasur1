package org.example.project_1.servlet.userServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project_1.entity.User;
import org.example.project_1.repo.BaseRepo;
import org.example.project_1.repo.UserRepo;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userLogin",value = "/userLogin")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepo userRepo = new UserRepo();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email);
        List<User> users = userRepo.findAll();
        for (User user : users) {
            if(user.getEmail().equals(email) ) {
                if(user.getPassword().equals(password)) {
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect("http://localhost:8080/index.jsp");
                }
            }

        }
    }
}
