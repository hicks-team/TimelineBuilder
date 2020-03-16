package com.hicks.team.services;

import com.hicks.team.models.InvalidRequestException;
import com.hicks.team.models.User;
import com.hicks.team.repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserService {

    @Qualifier("mockUserRepository")
    private UserRepository userRepository;

    @Autowired()
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Supplier<Long> idSupplier) throws InvalidRequestException {
        Optional<User> user;
        try {
            user = userRepository.findById(idSupplier.get());
        } catch (NumberFormatException e) {
            throw new InvalidRequestException("User.ID must be integer value");
        }

        if (user.isEmpty())
            throw new InvalidRequestException("User.ID not found.");

        return user.get();
    }
}
