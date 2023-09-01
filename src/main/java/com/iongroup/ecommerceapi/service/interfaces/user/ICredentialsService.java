package com.iongroup.ecommerceapi.service.interfaces.user;

import com.iongroup.ecommerceapi.entity.user.Credentials;

import java.util.List;
import java.util.Optional;

public interface ICredentialsService {
    Optional<Credentials> findById(Long id);
    Optional<Credentials> findByEmail(String email);
    Optional<Credentials> findByPhoneNumber(String phoneNumber);
    List<Credentials> findAll();
    void save(Credentials credentials);
    void update(Credentials credentials, Credentials updatedCredentials);
    void delete(Long id);
}
