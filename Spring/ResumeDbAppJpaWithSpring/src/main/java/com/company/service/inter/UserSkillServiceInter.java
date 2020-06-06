package com.company.service.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillServiceInter {
    List<UserSkill> getAllUserSkills(User user);

    boolean insertUserSkill(UserSkill userSkill);

    boolean updateUserSkill(UserSkill userSkill);

    boolean deleteUserSkill(int userSkillId);
}
