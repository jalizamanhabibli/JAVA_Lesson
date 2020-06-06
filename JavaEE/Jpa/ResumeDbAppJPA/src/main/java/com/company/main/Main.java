package com.company.main;

import com.company.dao.inter.UserDaoInter;
public class Main {

    public static void main(String[] args) {
        UserDaoInter daoInter=Context.instanceUserDao();
        System.out.println(daoInter.getByEmail("elizaman196@gmail.com"));
    }
}
