package com.company.entity;

public class Skill {
    private Integer id;

    private String name;

    public Skill() {}

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id.intValue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
