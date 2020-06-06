package com.company.repository.impl;

import com.company.repository.inter.jpa_inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistorys(User user) {
        return user.getEmploymentHistoryList();
    }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory history) {
        manager.persist(history);
        return true;
    }

    @Override
    public boolean deleteEmploymentHistory(int EmploymentId) {
        EmploymentHistory history = manager.find(EmploymentHistory.class, EmploymentId);
        manager.remove(history);
        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory history) {
        manager.merge(history);
        return true;
    }
}
