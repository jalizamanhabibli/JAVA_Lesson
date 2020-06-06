package com.company.service.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;

import java.util.List;

public interface EmploymentHistoryServiceInter {
    List<EmploymentHistory> getAllEmploymentHistorys(User user);

    boolean insertEmploymentHistory(EmploymentHistory history);

    boolean updateEmploymentHistory(EmploymentHistory history);

    boolean deleteEmploymentHistory(int EmploymentId);
}
