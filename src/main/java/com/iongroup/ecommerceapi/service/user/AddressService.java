package com.iongroup.ecommerceapi.service.user;

import com.iongroup.ecommerceapi.entity.user.Address;
import com.iongroup.ecommerceapi.repository.user.AddressRepository;
import com.iongroup.ecommerceapi.service.interfaces.user.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void update(Address address, Address updatedAddress) {
        BeanUtils.copyProperties(updatedAddress, address,
                "id", "user");
        addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
