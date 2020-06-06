package com.company.repository.inter.jpa_inter;

import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAllUserSkills(User user);

    boolean insertUserSkill(UserSkill userSkill);

    boolean updateUserSkill(UserSkill userSkill);

    boolean deleteUserSkill(int userSkillId);
}
