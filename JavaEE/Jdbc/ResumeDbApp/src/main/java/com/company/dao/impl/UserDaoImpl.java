package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    private User getUser(ResultSet rs) {
        User user = null;
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String number = rs.getString("phone");
            String profilDescription = rs.getString("profile_description");
            String address = rs.getString("address");
            Date date = rs.getDate("birthdate");
            int birthplaceId = rs.getInt("birthplace_id");
            int nationalityId = rs.getInt("nationality_id");
            String nationalityStr = rs.getString("nationality");
            String birthplaceStr = rs.getString("name");
            Country nationality = new Country(nationalityId, null, nationalityStr);
            Country birthplace = new Country(birthplaceId, birthplaceStr, null);
            user = new User(Integer.valueOf(id), name, surname, email, number, profilDescription, address, date, nationality, birthplace);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    private User getUserByEmailOrPassword(ResultSet rs) {
        User user = null;
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String password = rs.getString("password");
            user = new User(id, name, surname, email, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connect = connect()) {
            String query = "select u.*,  n1.nationality nationality, n2.name birthplace from user u inner join country n1 on u.nationality_id = n1.id inner join country n2 on u.birthplace_id = n2.id order by id";
            Statement stmp = connect.createStatement();
            stmp.execute(query);
            ResultSet rs = stmp.getResultSet();
            while (rs.next()) {
                User user = getUser(rs);
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(User user) {
        try (Connection connect = connect()) {
            String query = "UPDATE USER SET name =?, surname =?, email =?, password=?, phone =?, profile_description =?, address =?, birthdate =?, birthplace_id =?, nationality_id =? WHERE id =?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setString(1, user.getName());
            stmp.setString(2, user.getSurname());
            stmp.setString(3, user.getEmail());
            stmp.setString(4, user.getPassword());
            stmp.setString(5, user.getNumber());
            stmp.setString(6, user.getProfileDescription());
            stmp.setString(7, user.getAddress());
            stmp.setDate(8, user.getBirthDate());
            stmp.setInt(9, user.getBirthPlace().getId());
            stmp.setInt(10, user.getNationality().getId());
            stmp.setInt(11, user.getId());
            int lineCount = stmp.executeUpdate();
            return (lineCount > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(int id) {
        try (Connection connect = connect()) {
            PreparedStatement stmp = connect.prepareStatement("delete from user where id=?");
            stmp.setInt(1, id);
            int lineCount = stmp.executeUpdate();
            return (lineCount > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    private BCrypt.Hasher bCrypt = BCrypt.withDefaults();
    public boolean addUser(User user) {
        try (Connection connect = connect()) {
            String query = "INSERT INTO USER ( name, surname, email, password, phone, profile_description, address, birthdate, birthplace_id, nationality_id ) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setString(1, user.getName());
            stmp.setString(2, user.getSurname());
            stmp.setString(3, user.getEmail());
            stmp.setString(4, bCrypt.hashToString(4, user.getPassword().toCharArray()));
            stmp.setString(5, user.getNumber());
            stmp.setString(6, user.getProfileDescription());
            stmp.setString(7, user.getAddress());
            stmp.setDate(8, user.getBirthDate());
            stmp.setInt(9, user.getBirthPlace().getId());
            stmp.setInt(10, user.getNationality().getId());
            int lineCount = stmp.executeUpdate();
            return (lineCount > 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public User getById(int id) {
        try (Connection connect = connect()) {
            String query = "select u.*,  n1.nationality nationality, n2.name birthplace from user u inner join country n1 on u.nationality_id = n1.id inner join country n2 on u.birthplace_id = n2.id where u.id=?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setInt(1, id);
            ResultSet rs = stmp.executeQuery();
            if (rs.next())
                return getUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        try (Connection connect = connect()) {
            String query = "select u.id,u.name,u.surname,u.email,u.password from user u where email=? and password=?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setString(1, email);
            stmp.setString(2, password);
            ResultSet rs = stmp.executeQuery();
            if (rs.next())
                return getUserByEmailOrPassword(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        try (Connection connect = connect()) {
            String query = "select u.id,u.name,u.surname,u.email,u.password from user u where email=?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setString(1, email);
            ResultSet rs = stmp.executeQuery();
            if (rs.next())
                return getUserByEmailOrPassword(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<User> searchAllUser(String name, String surname) {
        List<User> users = new ArrayList<>();
        try (Connection connect = connect()) {
            String query = "select u.*, n1.nationality nationality, n2.name birthplace from user u inner join country n1 on u.nationality_id = n1.id inner join country n2 on u.birthplace_id = n2.id where 1=1 ";
            if (name != null && !name.trim().isEmpty())
                query = query + "and u.name = ? ";
            if (surname != null && !surname.trim().isEmpty())
                query = query + "and u.surname = ?";
            query += " order by id";
            PreparedStatement stmp = connect.prepareStatement(query);
            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                stmp.setString(i, name);
                i++;
            }
            if (surname != null && !surname.trim().isEmpty())
                stmp.setString(i, surname);
            ResultSet rs = stmp.executeQuery();
            while (rs.next()) {
                User user = getUser(rs);
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
