package com.iongroup.ecommerceapi.service.user;

import com.iongroup.ecommerceapi.entity.user.User;
import com.iongroup.ecommerceapi.repository.user.UserRepository;
import com.iongroup.ecommerceapi.service.interfaces.user.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user, User updatedUser) {
        BeanUtils.copyProperties(updatedUser, user,
                "id", "credentials", "addresses", "orders", "carts", "reviews", "wishlist");
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
