package com.company.dao.inter;

import com.company.entity.User;
import java.util.List;

public interface UserDaoInter {
    List<User> getAll();

    boolean updateUser(User paramUser);

    boolean removeUser(int paramInt);

    boolean addUser(User paramUser);

    User getById(int paramInt);

    User getByEmailAndPassword(String email,String password);

    User getByEmail(String email);

    List<User> searchAllUser(String paramString1, String paramString2);
}
