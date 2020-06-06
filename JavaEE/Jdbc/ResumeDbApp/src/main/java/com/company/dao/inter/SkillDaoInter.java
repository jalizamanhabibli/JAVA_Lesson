package com.company.dao.inter;

import com.company.entity.Skill;
import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAllSkill();

    boolean insertSkill(Skill paramSkill);

    boolean deleteSkill(int paramInt);
}
