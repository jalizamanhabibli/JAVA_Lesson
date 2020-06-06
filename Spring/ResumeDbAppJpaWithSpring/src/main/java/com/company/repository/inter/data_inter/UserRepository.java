package com.company.repository.inter.data_inter;

import com.company.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    @Cacheable(value = "users")
    List<User> findAll();

    @Override
    @CacheEvict(value = "users" , allEntries = true)
    void deleteById(Integer id);

    @Override
    @CacheEvict(value = "users" , allEntries = true)
    <S extends User> S save(S s);

    @Cacheable(value = "users")
    List<User> findByNameContainingAndSurnameContaining(String name, String surname);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
