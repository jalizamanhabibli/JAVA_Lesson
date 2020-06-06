package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
        @Override
    public List<Skill> getAllSkills() {
        EntityManager manager = em();
        Query query = manager.createNamedQuery("Skill.findAll");
        List<Skill> list = query.getResultList();
        manager.close();
        return list;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.persist(skill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteSkill(int id) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        Skill skill = manager.find(Skill.class, id);
        manager.remove(skill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
}
