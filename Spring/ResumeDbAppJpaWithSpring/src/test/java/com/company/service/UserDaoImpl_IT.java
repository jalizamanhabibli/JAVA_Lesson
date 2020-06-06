package com.company.service;

import com.company.entity.User;
import com.company.repository.impl.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 01/06/2020
 * Time: 17:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoImpl_IT {
    @Autowired
    UserDaoImpl userDao;

    @Test
    public void testGetAll(){
        List<User> userList = userDao.getAll();
        System.out.println(userList);
    }
}
