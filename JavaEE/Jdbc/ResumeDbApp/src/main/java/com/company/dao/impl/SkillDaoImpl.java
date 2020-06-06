package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
    public List<Skill> getAllSkill() {
        List<Skill> skills = new ArrayList<>();
        try (Connection connect = connect()) {
            Skill skill = null;
            Statement stmp = connect.createStatement();
            stmp.execute("select * from skill");
            ResultSet rs = stmp.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                skill = new Skill(id, name);
                skills.add(skill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skills;
    }

    public boolean insertSkill(Skill skill) {
        boolean bool = false;
        String query = "insert into skill(name) values(?)";
        try (Connection connect = connect()) {
            PreparedStatement stmp = connect.prepareStatement(query, 1);
            stmp.setString(1, skill.getName());
            bool = (stmp.executeUpdate() > 0);
            ResultSet rs = stmp.getGeneratedKeys();
            if (rs.next())
                skill.setId(rs.getInt(1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    public boolean deleteSkill(int id) {
        boolean bool = false;
        String query = "delete from skill where id=?";
        try (Connection connect = connect()) {
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setInt(1, id);
            bool = (stmp.executeUpdate() > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }
}
