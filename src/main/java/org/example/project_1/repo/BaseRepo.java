package org.example.project_1.repo;

import jakarta.persistence.EntityManager;
import org.example.project_1.config.DB;
import org.example.project_1.entity.Group;
import org.example.project_1.entity.User;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseRepo<T, I> {
    protected static final EntityManager em = DB.entityManagerFactory.createEntityManager();

    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseRepo() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }

    public void save(T entity) {
        beginTransaction();
        em.persist(entity);
        commitTransaction();
    }

    public void delete(T entity) {
        beginTransaction();
        em.remove(entity);
        commitTransaction();
    }

    public T findById(I id) {
        return em.find(clazz, id);
    }

    public List<T> findAll() {
        return em.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
    }

    public void edit(T entity, Integer id) {
        beginTransaction();
        T t = findById((I) id);
        if (t != null) {
            if (entity instanceof User && t instanceof User) {
                User user = (User) entity;
                User setUser = (User) t;
                setUser.setEmail(user.getEmail());
                setUser.setPassword(user.getPassword());
                setUser.setFirstName(user.getFirstName());
                setUser.setLastName(user.getLastName());
                setUser.setGroup(user.getGroup());
                em.merge(setUser);
            } else if (entity instanceof Group && t instanceof Group) {
                Group group = (Group) entity;
                Group setGroup = (Group) t;
                setGroup.setId(group.getId());
                setGroup.setName(group.getName());
                em.merge(setGroup);
            }
        }
        commitTransaction();
    }
}
