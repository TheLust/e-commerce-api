package com.iongroup.ecommerceapi.repository.user;

import com.iongroup.ecommerceapi.entity.user.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository  extends JpaRepository<Credentials, Long> {
    Optional<Credentials> findByEmail(String email);
    Optional<Credentials> findByPhoneNumber(String phoneNumber);
}
