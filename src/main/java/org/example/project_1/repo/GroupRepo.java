package org.example.project_1.repo;

import org.example.project_1.entity.Group;

import java.util.List;

public class GroupRepo {
    private static final BaseRepo<Group,Integer> base = new BaseRepo<>();
    public static List<Group> findAll() {
        return base.findAll();
    }
}
