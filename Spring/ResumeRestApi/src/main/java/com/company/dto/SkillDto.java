package com.company.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 23/05/2020
 * Time: 12:46
 */
public class SkillDto {
    private Integer id;
    private String name;

    public SkillDto() {
    }

    public SkillDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
