package com.freefat.mvp.freefatmvp.service;

import com.freefat.mvp.freefatmvp.models.User;
import com.freefat.mvp.freefatmvp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user)
    {   Optional<User> oUserToValidate = findUserByEmail(user.getEmail());
        if (oUserToValidate.isPresent()) { return null; }
        else { return repository.save(user); }
    }

    @Override
    public Optional<User> signInUser(User user)
    { return repository.findByEmailAndPassword(user.getEmail(), user.getPassword()); }

    @Override
    public Optional<User> findUserById(String id)
    {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) { return repository.findByEmail(email); }
}
