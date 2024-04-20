package org.example.project_1.servlet.userServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project_1.entity.Group;
import org.example.project_1.entity.User;
import org.example.project_1.repo.BaseRepo;

import java.io.IOException;

@WebServlet(name = "userEdit",value = "/userEdit")
public class UserEditServlet extends HttpServlet {
    private static final BaseRepo<User,Integer> userRepo = new BaseRepo<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Integer groupId = Integer.parseInt(req.getParameter("groupId"));
        Group group = userRepo.findById(groupId).getGroup();
        User user = new User(lastName,firstName,email,password,group);
        userRepo.edit(user,id);
    }
}
