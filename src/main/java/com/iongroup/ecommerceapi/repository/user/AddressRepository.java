package com.iongroup.ecommerceapi.repository.user;

import com.iongroup.ecommerceapi.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
