package com.iongroup.ecommerceapi.service;

import com.iongroup.ecommerceapi.entity.Wish;
import com.iongroup.ecommerceapi.repository.WishRepository;
import com.iongroup.ecommerceapi.service.interfaces.IWishService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WishService implements IWishService {

    private final WishRepository wishRepository;

    @Override
    public Optional<Wish> findById(Long id) {
        return wishRepository.findById(id);
    }

    @Override
    public List<Wish> findAll() {
        return wishRepository.findAll();
    }

    @Override
    public void save(Wish wish) {
        wishRepository.save(wish);
    }

    @Override
    public void delete(Long id) {
        wishRepository.deleteById(id);
    }
}
