package org.example.project_1.servlet.gurpServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project_1.entity.Group;
import org.example.project_1.repo.BaseRepo;

import java.io.IOException;

@WebServlet(name = "gurpDelete",value = "/gurpDelete")
public class GurpDeleteServlet extends HttpServlet {

    private static final BaseRepo<Group,Integer> baseRepo = new BaseRepo<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Group group = baseRepo.findById(id);
        baseRepo.delete(group);
    }

}
