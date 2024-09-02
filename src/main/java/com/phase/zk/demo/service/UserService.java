package com.phase.zk.demo.service;

import com.phase.zk.demo.dto.UserDto;
import com.phase.zk.demo.exception.ApiRequestException;
import com.phase.zk.demo.model.User;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
//    Optional<User> findByEmail(String email) throws NotFoundException;
    User saveUser(UserDto userDto);
    Optional<User> getById(Integer id) throws ApiRequestException;
    void deleteById(Integer id);
    UserDto updateById(Integer id, UserDto userDto);

}
