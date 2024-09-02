package com.phase.zk.demo.service.impl;

import com.phase.zk.demo.dto.UserDto;
import com.phase.zk.demo.exception.ApiRequestException;
import com.phase.zk.demo.model.User;
import com.phase.zk.demo.repository.UserRepository;
import com.phase.zk.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

//    @Override
//    public Optional<User> findByEmail(String email) throws NotFoundException {
//        Optional<User> user = repository.findByEmail(email);
//        if (user.isPresent()){
//            return user;
//        }
//        else throw new NotFoundException("User with Email: "+email+" Not found");
//    }

    @Override
    public User saveUser(UserDto userDto) {
        String email = userDto.getEmail();
        Optional<User> existingUser = repository.findByEmail(email);
        if (existingUser.isPresent()){
            throw new ApiRequestException("User with Email "+email+" Already Exist");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        return repository.save(user);
    }

    @Override
    public Optional<User> getById(Integer id) throws ApiRequestException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            return user;
        }
        else throw new ApiRequestException("User with ID: "+id+" Not ound");
    }

    @Override
    public void deleteById(Integer id) {
        Optional<User> userToDelete = repository.findById(id);
        if (userToDelete.isPresent()){
            repository.deleteById(id);
        }else throw new ApiRequestException("no User with Id: "+id);
    }

    @Override
    public UserDto updateById(Integer id, UserDto userDto) {
        User user = repository.findById(id).orElseThrow(() -> new ApiRequestException("User with ID: "+id+" Not found"));;
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        repository.save(user);
        return userDto;
    }
}
