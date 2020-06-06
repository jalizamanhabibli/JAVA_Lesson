package com.company.repository.inter.jpa_inter;

import com.company.entity.Skill;
import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAllSkills();

    boolean insertSkill(Skill skill);

    boolean deleteSkill(int id);
}
