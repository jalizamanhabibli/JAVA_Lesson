package com.company.service.impl.jpa_impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.repository.inter.jpa_inter.CountryDaoInter;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("countryServiceImpl")
@Transactional
public class CountryServiceImpl implements CountryServiceInter {

    @Autowired
    private CountryDaoInter countryDaoInter;

    @Override
    public List<Country> getAllCountries() {
        List<Country> countryList=countryDaoInter.getAllCountries();
        return countryList;
    }

    @Override
    public Country getCountryById(int id) {
       Country country=countryDaoInter.getCountryById(id);
       return country;
    }

    @Override
    public Country getCountryByUser(User user) {
        Country country=countryDaoInter.getCountryByUser(user);
        return country;
    }

    @Override
    public boolean insertCountry(Country country) {
       countryDaoInter.insertCountry(country);
       return true;
    }

}
