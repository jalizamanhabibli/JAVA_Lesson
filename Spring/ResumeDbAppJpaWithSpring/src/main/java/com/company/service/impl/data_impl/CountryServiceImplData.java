package com.company.service.impl.data_impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.repository.inter.data_inter.CountryRepository;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countryServiceImplData")
@Transactional
public class CountryServiceImplData implements CountryServiceInter {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        List<Country> countryList=countryRepository.findAll();
        return countryList;
    }

    @Override
    public Country getCountryById(int id) {
       Country country=countryRepository.getOne(id);
       return country;
    }

    @Override
    public Country getCountryByUser(User user) {
        return user.getBirthPlace();
    }

    @Override
    public boolean insertCountry(Country country) {
        countryRepository.save(country);
       return true;
    }

}
