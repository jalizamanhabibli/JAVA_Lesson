package com.company.repository.inter.jpa_inter;

import com.company.entity.User;
import java.util.List;

public interface UserDaoInter {
    List<User> getAll();
    
    List<User> searchAllUser(String name, String surname);
    
    User getById(int userId);

    User getByEmail(String email);
    
    User getByEmailAndPassword(String email,String password);
    
    boolean addUser(User user);

    boolean updateUser(User user);

    boolean removeUser(int userId);
}
