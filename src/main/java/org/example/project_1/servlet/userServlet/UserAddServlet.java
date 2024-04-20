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
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "userAdd",value = "/userAdd")
public class UserAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepo userRepo = new UserRepo();
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String check = BCrypt.hashpw(password, BCrypt.gensalt());
        Integer groupId = Integer.parseInt(req.getParameter("groupId"));
        Group group = userRepo.findById(groupId).getGroup();
        User user = new User(lastName,firstName,email,check,group);
        System.out.println(user);
        userRepo.save(user);
    }
}
