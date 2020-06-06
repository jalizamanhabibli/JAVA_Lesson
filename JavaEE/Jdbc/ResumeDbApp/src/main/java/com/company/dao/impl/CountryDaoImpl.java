package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {
    public List<Country> getAllCountry() {
        List<Country> countries = new ArrayList<>();
        try (Connection connect = connect()) {
            Country country = null;
            Statement stmp = connect.createStatement();
            stmp.execute("select * from country");
            ResultSet rs = stmp.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String countryName = rs.getString("name");
                String nationality = rs.getString("nationality");
                country = new Country(id, countryName, nationality);
                countries.add(country);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countries;
    }

    public Country getById(int id) {
        try (Connection connect = connect()) {
            String query = "select *from country where id=?";
            PreparedStatement stmp = connect.prepareStatement(query);
            stmp.setInt(1, id);
            ResultSet rs = stmp.executeQuery();
            if (rs.next())
                return new Country(rs.getInt("id"), rs.getString("name"), rs.getString("nationality"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
