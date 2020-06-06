package com.company.entity;

public class UserSkill {
    private Integer id;

    private User user;

    private Skill skill;

    private int power;

    public UserSkill() {}

    public UserSkill(Integer id, User user, Skill skill, int power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }

    public int getId() {
        return this.id.intValue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return this.skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString() {
        return "UserSkill{id=" + this.id + ", user=" + this.user + ", skill=" + this.skill + ", power=" + this.power + '}';
    }
}
