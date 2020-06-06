package com.company.entity;

import java.sql.Date;

public class EmploymentHistory {
    private Integer id;

    private String header;

    private Date beginDate;

    private Date endDate;

    private String JobDescription;

    private User user;

    public EmploymentHistory() {}

    public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.JobDescription = jobDescription;
        this.user = user;
    }

    public int getId() {
        return this.id.intValue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return this.JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.JobDescription = jobDescription;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "EmploymentHistory{id=" + this.id + ", header='" + this.header + '\'' + ", beginDate=" + this.beginDate + ", endDate=" + this.endDate + ", JobDescription='" + this.JobDescription + '\'' + ", user=" + this.user + '}';
    }
}
