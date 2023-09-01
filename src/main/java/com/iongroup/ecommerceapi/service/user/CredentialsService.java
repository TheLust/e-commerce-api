package com.iongroup.ecommerceapi.service.user;

import com.iongroup.ecommerceapi.entity.user.Credentials;
import com.iongroup.ecommerceapi.repository.user.CredentialsRepository;
import com.iongroup.ecommerceapi.service.interfaces.user.ICredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CredentialsService implements ICredentialsService {

    private final CredentialsRepository credentialsRepository;

    @Override
    public Optional<Credentials> findById(Long id) {
        return credentialsRepository.findById(id);
    }

    @Override
    public Optional<Credentials> findByEmail(String email) {
        return credentialsRepository.findByEmail(email);
    }

    @Override
    public Optional<Credentials> findByPhoneNumber(String phoneNumber) {
        return credentialsRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Credentials> findAll() {
        return credentialsRepository.findAll();
    }

    @Override
    public void save(Credentials credentials) {
        credentialsRepository.save(credentials);
    }

    @Override
    public void update(Credentials credentials, Credentials updatedCredentials) {
        BeanUtils.copyProperties(updatedCredentials, credentials,
                "id", "user");
        credentialsRepository.save(credentials);
    }

    @Override
    public void delete(Long id) {
        credentialsRepository.deleteById(id);
    }
}
