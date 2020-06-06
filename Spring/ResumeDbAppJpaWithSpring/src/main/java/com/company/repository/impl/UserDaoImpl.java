package com.company.repository.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.repository.inter.jpa_inter.UserDaoInter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDaoInter {

    @PersistenceContext
    private EntityManager manager;

    private BCrypt.Hasher bCrypt = BCrypt.withDefaults();

    @Override
    @Cacheable("users")
    public List<User> getAll() {
        Query query = manager.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    @Cacheable("users")
    public List<User> searchAllUser(String name, String surname) {
        name=name==null?"":name;
        surname=surname==null?"":surname;
        String jpql = "Select u from User u where u.name like :name and u.surname like :surname";
        Query query = manager.createQuery(jpql);
        query.setParameter("name", "%" + name + "%");
        query.setParameter("surname", "%" + surname + "%");
        List<User> users=query.getResultList();
        return users;
    }

    @Override
    public User getById(int userId) {
        User user = manager.find(User.class, userId);
        return user;
    }

    @Override
    public User getByEmail(String email) {
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :email and u.password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    @CacheEvict(value = "users" , allEntries = true)
    public boolean addUser(User user) {
        user.setPassword(bCrypt.hashToString(4,user.getPassword().toCharArray()));
        manager.persist(user);
        return true;
    }

    @Override
    @CacheEvict(value = "users" , allEntries = true)
    public boolean updateUser(User user) {
        manager.merge(user);
        return true;
    }

    @Override
    @CacheEvict(value = "users" , allEntries = true)
    public boolean removeUser(int userId) {
        User user = manager.find(User.class, userId);
        manager.remove(user);
        return true;
    }

}
