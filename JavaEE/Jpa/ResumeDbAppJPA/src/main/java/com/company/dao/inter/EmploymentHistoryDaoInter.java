package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    List<EmploymentHistory> getAllEmploymentHistorys(User user);

    boolean insertEmploymentHistory(EmploymentHistory history);

    boolean updateEmploymentHistory(EmploymentHistory history);

    boolean deleteEmploymentHistory(int EmploymentId);
}
