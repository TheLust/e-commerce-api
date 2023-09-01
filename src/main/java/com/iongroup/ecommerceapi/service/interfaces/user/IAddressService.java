package com.iongroup.ecommerceapi.service.interfaces.user;

import com.iongroup.ecommerceapi.entity.user.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Optional<Address> findById(Long id);
    List<Address> findAll();
    void save(Address address);
    void update(Address address, Address updatedAddress);
    void delete(Long id);
}
