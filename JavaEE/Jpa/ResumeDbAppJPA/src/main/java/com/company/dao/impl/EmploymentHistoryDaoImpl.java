package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    @Override
    public List<EmploymentHistory> getAllEmploymentHistorys(User user) {
        return user.getEmploymentHistoryList();
    }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory history) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.persist(history);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteEmploymentHistory(int EmploymentId) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        EmploymentHistory history = manager.find(EmploymentHistory.class, EmploymentId);
        manager.remove(history);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory history) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.merge(history);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
}
