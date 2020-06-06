package com.company.service.inter;

import com.company.entity.Country;
import com.company.entity.User;

import java.util.List;

public interface CountryServiceInter {
    List<Country> getAllCountries();
    
    Country getCountryById(int id);
    
    Country getCountryByUser(User user);

    boolean insertCountry(Country country);
}
