package org.example.project_1.config;

import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.project_1.entity.Group;
import org.example.project_1.entity.User;
import org.example.project_1.repo.GroupRepo;
import org.example.project_1.repo.UserRepo;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DB.entityManagerFactory = Persistence.createEntityManagerFactory("ORM_EXAMPLE");
        DB.entityManager = DB.entityManagerFactory.createEntityManager();
        ServletContextListener.super.contextInitialized(sce);
        NewUserDb();
    }

    private void NewUserDb() {
        UserRepo userRepo = new UserRepo();
        GroupRepo groupRepo = new GroupRepo();
        Group group1 = new Group(
                "Db"
        );
        groupRepo.save(group1);
        Group group = groupRepo.findById(group1.getId());
        User user = new User(
                "qqq",
                "Www",
                "wer@gmail.com",
                "www777",
                group
        );
        userRepo.save(user);
    }


}
