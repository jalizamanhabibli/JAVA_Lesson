package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;
import javax.persistence.EntityManager;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllUserSkills(User user) {
        return user.getSkills();
    }

    @Override
    public boolean insertUserSkill(UserSkill userSkill) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.persist(userSkill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.merge(userSkill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteUserSkill(int userSkillId) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        UserSkill userSkill = manager.find(UserSkill.class, userSkillId);
        manager.remove(userSkill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
}
