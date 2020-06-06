package com.company.service.impl.data_impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.repository.inter.data_inter.UserRepository;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServiceImplData")
@Transactional
public class UserServiceImplData implements UserServiceInter {

    @Autowired
    private UserRepository userRepository;

    BCrypt.Hasher bCrypt=BCrypt.withDefaults();

    @Override
    public List<User> getAll() {
        List<User> userList=userRepository.findAll();
        return userList;
    }

    @Override
    public List<User> searchAllUser(String name, String surname) {
        name=name==null?"":name;
        surname=surname==null?"":surname;
        List<User> userList=userRepository.findByNameContainingAndSurnameContaining(name, surname);
        return userList;
    }

    @Override
    public User getById(int userId) {
        User user=userRepository.findById(userId).get();
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user=userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user=userRepository.findByEmailAndPassword(email,password);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        user.setPassword(bCrypt.hashToString(4,user.getPassword().toCharArray()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean removeUser(int userId) {
        userRepository.deleteById(userId);
        return true;
    }
}
