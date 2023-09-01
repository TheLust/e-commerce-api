package com.iongroup.ecommerceapi.service.interfaces.user;

import com.iongroup.ecommerceapi.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    void save(User user);
    void update(User user, User updatedUser);
    void delete(Long id);
}
