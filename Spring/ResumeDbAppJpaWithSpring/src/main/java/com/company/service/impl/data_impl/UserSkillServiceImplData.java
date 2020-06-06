package com.company.service.impl.data_impl;

import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.repository.inter.data_inter.UserSkillRepository;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userSkillServiceImplData")
@Transactional
public class UserSkillServiceImplData implements UserSkillServiceInter {

    @Autowired
    private UserSkillRepository userSkillRepository;

    @Override
    public List<UserSkill> getAllUserSkills(User user) {
        return user.getSkills();
    }

    @Override
    public boolean insertUserSkill(UserSkill userSkill) {
        userSkillRepository.save(userSkill);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        userSkillRepository.save(userSkill);
        return true;
    }

    @Override
    public boolean deleteUserSkill(int userSkillId) {
        userSkillRepository.deleteById(userSkillId);
        return true;
    }
}
