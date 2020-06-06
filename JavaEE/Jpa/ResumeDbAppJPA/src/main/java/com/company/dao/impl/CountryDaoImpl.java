package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAllCountries() {
        EntityManager manager = em();
        Query query = manager.createNamedQuery("Country.findAll", Country.class);
        List<Country> countries = query.getResultList();
        manager.close();
        return countries;
    }

    @Override
    public Country getCountryById(int id) {
        EntityManager manager = em();
        Query query = manager.createNamedQuery("Country.findById", Country.class);
        query.setParameter("id",id);
        List<Country> countries = query.getResultList();
        manager.close();
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
    public boolean insertCountry(Country counrty) {
        EntityManager manager = em();
        manager.getTransaction().begin();
        manager.persist(counrty);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

}
