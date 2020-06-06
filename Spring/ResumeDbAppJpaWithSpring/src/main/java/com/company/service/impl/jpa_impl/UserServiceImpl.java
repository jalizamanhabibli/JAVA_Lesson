package com.company.service.impl.jpa_impl;

import com.company.entity.User;
import com.company.repository.inter.jpa_inter.UserDaoInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private UserDaoInter userDaoInter;

    @Override
    public List<User> getAll() {
        List<User> userList = userDaoInter.getAll();
        return userList;
    }

    @Override
    public List<User> searchAllUser(String name, String surname) {
        List<User> userList = userDaoInter.searchAllUser(name,surname);
        return userList;
    }

    @Override
    public User getById(int userId) {
        User user = userDaoInter.getById(userId);
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user = userDaoInter.getByEmail(email);
        return user;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user = userDaoInter.getByEmailAndPassword(email,password);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        userDaoInter.addUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        userDaoInter.updateUser(user);
        return true;
    }

    @Override
    public boolean removeUser(int userId) {
        userDaoInter.removeUser(userId);
        return true;
    }

}
