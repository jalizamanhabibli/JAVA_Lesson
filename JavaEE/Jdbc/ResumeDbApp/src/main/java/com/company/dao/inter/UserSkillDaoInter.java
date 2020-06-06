package com.company.dao.inter;

import com.company.entity.UserSkill;
import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAllSkillByUserId(int paramInt);

    boolean insertUserSkill(UserSkill paramUserSkill);

    boolean removeUserSkill(int paramInt);
}
