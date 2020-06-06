package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaDelete;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private final BCrypt.Hasher bCrypt = BCrypt.withDefaults();
    
// CriteriaBuilder
//    @Override
//    public List<User> getAll() {
//        EntityManager manager = em();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//        Query query = manager.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
//        manager.close();
//        return users;
//    }
    
// jpql
    @Override
    public List<User> getAll() {
        EntityManager manager = em();
        Query query = manager.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        manager.close();
        return users;
    }
    
// CriteriaBuilder
//    @Override
//    public List<User> searchAllUser(String name, String surname) {
//        name = name == null ? "" : name;
//        surname = surname == null ? "" : surname;
//
//        EntityManager manager = em();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.where(builder.like(root.get("name"), "%" + name + "%"), builder.like(root.get("surname"), "%" + surname + "%"));
//        Query query = manager.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
//        manager.close();
//        return users;
//    }
    
// jpql
    @Override
    public List<User> searchAllUser(String name, String surname) {
        name=name==null?"":name;
        surname=surname==null?"":surname;
        EntityManager manager = em();
        String jpql = "Select u from User u where u.name like :name and u.surname like :surname";
        Query query = manager.createQuery(jpql);
        query.setParameter("name", "%" + name + "%");
        query.setParameter("surname", "%" + surname + "%");
        List<User> users=query.getResultList();
        manager.close();
        return users;
    }
    
// CriteriaBuilder
//    @Override
//    public User getById(int userId) {
//        EntityManager manager = em();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.where(builder.equal(root.get("id"), userId));
//        Query query = manager.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
//        manager.close();
//        if (users.size() == 1) {
//            return users.get(0);
//        }
//        return null;
//    }
    
// jpql
    @Override
    public User getById(int userId) {
        EntityManager manager = em();
        User user = manager.find(User.class, userId);
        manager.close();
        return user;
    }
    
// CriteriaBuilder
//    @Override
//    public User getByEmail(String email) {
//        EntityManager manager = em();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.where(builder.equal(root.get("email"), email));
//        Query query = manager.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
//        manager.close();
//        if (users.size() == 1) {
//            return users.get(0);
//        }
//        return null;
//    }
    
// jpql
    @Override
    public User getByEmail(String email) {
        EntityManager manager = em();
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        manager.close();
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }
    
// CriteriaBuilder
//    @Override
//    public User getByEmailAndPassword(String email, String password) {
//        EntityManager manager = em();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.where(builder.equal(root.get("email"), email),builder.equal(root.get("password"), password));
//        Query query = manager.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
//        manager.close();
//        if (users.size() == 1) {
//            return users.get(0);
//        }
//        return null;
//    }
    
// jpql
    @Override
    public User getByEmailAndPassword(String email, String password) {
        EntityManager manager = em();
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.email = :email and u.password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        manager.close();
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        user.setPassword(bCrypt.hashToString(4, user.getPassword().toCharArray()));
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
// CriteriaBuilder
//    @Override
//    public boolean removeUser(int userId) {
//        EntityManager manager = em();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaDelete<User> queryDelete = builder.createCriteriaDelete(User.class);
//        Root<User> root=queryDelete.from(User.class);
//        queryDelete.where(builder.equal(root.get("id"), userId));
//        manager.getTransaction().begin();
//        Query query=manager.createQuery(queryDelete);
//        query.executeUpdate();
//        manager.getTransaction().commit();
//        manager.close();
//        return true;
//    }
    
// jpql
    @Override
    public boolean removeUser(int userId) {
        EntityManager manager = em();
        User user = manager.find(User.class, userId);
        manager.getTransaction().begin();
        manager.remove(user);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

}
