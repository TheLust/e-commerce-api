package com.iongroup.ecommerceapi.repository.customer;

import com.iongroup.ecommerceapi.entity.user.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository  extends JpaRepository<Credentials, Long> {
}
