package com.company.service.inter;

import com.company.entity.Skill;
import java.util.List;

public interface SkillServiceInter {
    List<Skill> getAllSkills();

    boolean insertSkill(Skill skill);

    boolean deleteSkill(int id);
}
