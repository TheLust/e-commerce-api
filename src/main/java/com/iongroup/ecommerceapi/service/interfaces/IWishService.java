package com.iongroup.ecommerceapi.service.interfaces;

import com.iongroup.ecommerceapi.entity.Wish;

import java.util.List;
import java.util.Optional;

public interface IWishService {
    Optional<Wish> findById(Long id);
    List<Wish> findAll();
    void save(Wish wish);
    void delete(Long id);
}
