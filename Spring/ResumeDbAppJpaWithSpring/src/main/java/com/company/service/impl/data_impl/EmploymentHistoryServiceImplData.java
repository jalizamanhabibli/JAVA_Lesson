package com.company.service.impl.data_impl;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.repository.inter.data_inter.EmploymentHistoryRepository;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employmentHistoryServiceImplData")
@Transactional
public class EmploymentHistoryServiceImplData implements EmploymentHistoryServiceInter {

    @Autowired
    private EmploymentHistoryRepository employmentHistoryRepository;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistorys(User user) {
        return user.getEmploymentHistoryList();
    }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory history) {
        employmentHistoryRepository.save(history);
        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory history) {
        employmentHistoryRepository.save(history);
        return true;
    }

    @Override
    public boolean deleteEmploymentHistory(int EmploymentId) {
        employmentHistoryRepository.deleteById(EmploymentId);
        return true;

    }
}
