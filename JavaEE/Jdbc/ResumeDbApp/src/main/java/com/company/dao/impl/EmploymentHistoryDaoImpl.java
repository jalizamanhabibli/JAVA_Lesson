package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {
    private EmploymentHistory getEmploymentHistory(ResultSet rs) {
        EmploymentHistory employmentHistory = null;
        try {
            String header = rs.getString("header");
            Date beginDate = rs.getDate("begin_date");
            Date endDate = rs.getDate("end_date");
            String jobDescription = rs.getString("job_description");
            int userId = rs.getInt("user_id");
            employmentHistory = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(Integer.valueOf(userId)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employmentHistory;
    }

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> employmentHistories = new ArrayList<>();
        try (Connection connect = connect()) {
            String query = "select * from employment_history where user_id=?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setInt(1, userId);
            ResultSet rs = stmp.executeQuery();
            while (rs.next()) {
                EmploymentHistory employmentHistory = getEmploymentHistory(rs);
                employmentHistories.add(employmentHistory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employmentHistories;
    }
}
