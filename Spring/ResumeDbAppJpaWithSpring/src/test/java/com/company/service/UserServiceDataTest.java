package com.company.service;

import com.company.entity.User;
import com.company.repository.impl.UserDaoImpl;
import com.company.repository.inter.data_inter.UserRepository;
import com.company.service.impl.data_impl.UserServiceImplData;
import com.company.service.impl.jpa_impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 01/06/2020
 * Time: 02:40
 */
public class UserServiceDataTest {

    @Spy
    UserDaoImpl userDao;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Before
    public void before(){
        System.out.println("Before Called");
        MockitoAnnotations.initMocks(this);
        List<User> userList= Arrays.asList(new User(1));
//        Mockito.when(userDao.getAll()).thenReturn(userList);
        Mockito.doReturn(userList).when(userDao).getAll();
//        Mockito.when(userDao.getByEmailAndPassword(null,null)).thenReturn(null);
        Mockito.doReturn(null).when(userDao).getByEmailAndPassword(null,null);
    }

    @Test
    public void testGetAll(){
        List<User> userList = userServiceImpl.getAll();
        Assert.assertEquals("User size must be 1" , userList.size(),1);
    }
    @Test
    public void testGetByEmailAndPassword(){
        User user=userServiceImpl.getByEmailAndPassword(null,null);
        Assert.assertNull("User must be null",user);
//        Mockito.verify(userDao,Mockito.atLeastOnce()).getByEmailAndPassword(null,null);
    }
}
