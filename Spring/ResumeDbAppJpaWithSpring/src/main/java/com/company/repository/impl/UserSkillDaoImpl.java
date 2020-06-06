package com.company.repository.impl;

import com.company.repository.inter.jpa_inter.UserSkillDaoInter;
import com.company.entity.User;
import com.company.entity.UserSkill;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<UserSkill> getAllUserSkills(User user) {
        return user.getSkills();
    }

    @Override
    public boolean insertUserSkill(UserSkill userSkill) {
        manager.persist(userSkill);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        manager.merge(userSkill);
        return true;
    }

    @Override
    public boolean deleteUserSkill(int userSkillId) {
        UserSkill userSkill = manager.find(UserSkill.class, userSkillId);
        manager.remove(userSkill);
        return true;
    }
}
