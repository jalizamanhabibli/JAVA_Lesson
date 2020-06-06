package com.company.repository.impl;

import com.company.repository.inter.jpa_inter.SkillDaoInter;
import com.company.entity.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class SkillDaoImpl implements SkillDaoInter {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Skill> getAllSkills() {
        Query query = manager.createNamedQuery("Skill.findAll");
        List<Skill> list = query.getResultList();
        return list;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        manager.persist(skill);
        return true;
    }

    @Override
    public boolean deleteSkill(int id) {
        Skill skill = manager.find(Skill.class, id);
        manager.remove(skill);
        return true;
    }
}
