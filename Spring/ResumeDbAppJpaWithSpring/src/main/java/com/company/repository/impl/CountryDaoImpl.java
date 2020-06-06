package com.company.repository.impl;

import com.company.repository.inter.jpa_inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Country> getAllCountries() {
        Query query = manager.createNamedQuery("Country.findAll", Country.class);
        List<Country> countries = query.getResultList();
        return countries;
    }

    @Override
    public Country getCountryById(int id) {
        Query query = manager.createNamedQuery("Country.findById", Country.class);
        query.setParameter("id",id);
        List<Country> countries = query.getResultList();
        if (countries.size() == 1) {
            return countries.get(0);
        }
        return null;
    }

    @Override
    public Country getCountryByUser(User user) {
        return user.getBirthPlace();
    }

    @Override
    public boolean insertCountry(Country country) {
        manager.persist(country);
        return true;
    }

}
