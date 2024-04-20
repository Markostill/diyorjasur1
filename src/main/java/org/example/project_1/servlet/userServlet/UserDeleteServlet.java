package org.example.project_1.servlet.userServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project_1.entity.Group;
import org.example.project_1.entity.User;
import org.example.project_1.repo.BaseRepo;
import org.example.project_1.repo.UserRepo;

import java.io.IOException;

@WebServlet(name = "userDelete",value = "/userDelete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepo userRepo = new UserRepo();
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = userRepo.findById(id);
        userRepo.delete(user);
    }
}
