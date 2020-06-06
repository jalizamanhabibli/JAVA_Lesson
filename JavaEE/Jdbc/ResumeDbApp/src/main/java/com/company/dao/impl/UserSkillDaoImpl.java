package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {
    private UserSkill getUserSkill(ResultSet rs) {
        UserSkill userSkill = null;
        try {
            int userSkilId = rs.getInt("userSkillId");
            int userId = rs.getInt("id");
            int skillId = rs.getInt("skill_id");
            String skillName = rs.getString("skill_name");
            int power = rs.getInt("power");
            userSkill = new UserSkill(Integer.valueOf(userSkilId), new User(Integer.valueOf(userId)), new Skill(skillId, skillName), power);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userSkill;
    }

    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> userSkills = new ArrayList<>();
        try (Connection connect = connect()) {
            String query = "select us.id userSkillId ,u.*,        us.skill_id,        s.name skill_name,        us.power from user_skill us          inner join user u on us.user_id = u.id          inner join skill s on us.skill_id = s.id where us.user_id=?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setInt(1, userId);
            ResultSet rs = stmp.executeQuery();
            while (rs.next()) {
                UserSkill user = getUserSkill(rs);
                userSkills.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userSkills;
    }

    public boolean insertUserSkill(UserSkill us) {
        String query = "insert into user_skill(user_id,skill_id,power) values(?,?,?)";
        boolean bool = false;
        try (Connection connect = connect()) {
            PreparedStatement stmp = connect.prepareStatement(query, 1);
            stmp.setInt(1, us.getUser().getId());
            stmp.setInt(2, us.getSkill().getId());
            stmp.setInt(3, us.getPower());
            bool = (stmp.executeUpdate() > 0);
            ResultSet rs = stmp.getGeneratedKeys();
            if (rs.next())
                us.setId(Integer.valueOf(rs.getInt(1)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    public boolean removeUserSkill(int id) {
        try (Connection connect = connect()) {
            PreparedStatement stmp = connect.prepareStatement("delete from user_skill where id=?");
            stmp.setInt(1, id);
            int lineCount = stmp.executeUpdate();
            return (lineCount > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
