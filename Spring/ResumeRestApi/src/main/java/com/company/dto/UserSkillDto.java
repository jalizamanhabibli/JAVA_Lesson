package com.company.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 23/05/2020
 * Time: 12:48
 */
public class UserSkillDto {
    private Integer id;
    private Integer power;
    private SkillDto skill;

    public UserSkillDto() {
    }

    public Integer getId() {
        return id;
    }

    public UserSkillDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public UserSkillDto setPower(Integer power) {
        this.power = power;
        return this;
    }

    public SkillDto getSkill() {
        return skill;
    }

    public UserSkillDto setSkill(SkillDto skill) {
        this.skill = skill;
        return this;
    }
}
