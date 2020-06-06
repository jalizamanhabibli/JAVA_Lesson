package com.company.service.impl.jpa_impl;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.repository.inter.jpa_inter.EmploymentHistoryDaoInter;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employmentHistoryServiceImpl")
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {

    @Autowired
    private EmploymentHistoryDaoInter employmentHistoryDaoInter;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistorys(User user) {
        List<EmploymentHistory> employmentHistoryList = employmentHistoryDaoInter.getAllEmploymentHistorys(user);
        return employmentHistoryList;
    }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory history) {
        employmentHistoryDaoInter.insertEmploymentHistory(history);
        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory history) {
        employmentHistoryDaoInter.updateEmploymentHistory(history);
        return true;
    }

    @Override
    public boolean deleteEmploymentHistory(int EmploymentId) {
        employmentHistoryDaoInter.deleteEmploymentHistory(EmploymentId);
        return true;

    }
}
