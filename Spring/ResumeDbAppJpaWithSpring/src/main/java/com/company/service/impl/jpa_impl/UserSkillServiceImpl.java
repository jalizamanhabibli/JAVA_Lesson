package com.company.service.impl.jpa_impl;

import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.repository.inter.jpa_inter.UserSkillDaoInter;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userSkillServiceImpl")
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    private UserSkillDaoInter userSkillDaoInter;

    @Override
    public List<UserSkill> getAllUserSkills(User user) {
        List<UserSkill> userSkillList = userSkillDaoInter.getAllUserSkills(user);
        return userSkillList;
    }

    @Override
    public boolean insertUserSkill(UserSkill userSkill) {
        userSkillDaoInter.insertUserSkill(userSkill);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        userSkillDaoInter.updateUserSkill(userSkill);
        return true;
    }

    @Override
    public boolean deleteUserSkill(int userSkillId) {
        userSkillDaoInter.deleteUserSkill(userSkillId);
        return true;
    }
}
