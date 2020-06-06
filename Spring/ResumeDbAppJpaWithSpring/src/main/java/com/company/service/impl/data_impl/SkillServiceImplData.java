package com.company.service.impl.data_impl;

import com.company.entity.Skill;
import com.company.repository.inter.data_inter.SkillRepository;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("skillServiceImplData")
@Transactional
public class SkillServiceImplData implements SkillServiceInter {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> skillList = skillRepository.findAll();
        return skillList;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        skillRepository.save(skill);
        return true;
    }

    @Override
    public boolean deleteSkill(int id) {
        skillRepository.deleteById(id);
        return true;
    }
}
