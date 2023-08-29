package com.iongroup.ecommerceapi.repository.customer;

import com.iongroup.ecommerceapi.entity.user.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
}
