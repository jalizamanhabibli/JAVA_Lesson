package com.company.service.impl.jpa_impl;

import com.company.entity.Skill;
import com.company.repository.inter.jpa_inter.SkillDaoInter;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("skillServiceImpl")
@Transactional
public class SkillServiceImpl implements SkillServiceInter {

    @Autowired
    private SkillDaoInter skillDaoInter;

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> skillList = skillDaoInter.getAllSkills();
        return skillList;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        skillDaoInter.insertSkill(skill);
        return true;
    }

    @Override
    public boolean deleteSkill(int id) {
        skillDaoInter.deleteSkill(id);
        return true;
    }
}
