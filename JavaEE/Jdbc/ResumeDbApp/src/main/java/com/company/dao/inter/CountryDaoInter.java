package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;

public interface CountryDaoInter {
    List<Country> getAllCountry();

    Country getById(int paramInt);
}
