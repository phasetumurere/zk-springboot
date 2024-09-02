package com.phase.zk.demo.controller;

import com.phase.zk.demo.dto.UserDto;
import com.phase.zk.demo.exception.ApiRequestException;
import com.phase.zk.demo.model.User;
import com.phase.zk.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User saveUser(@RequestBody UserDto userDto){
        User user = service.saveUser(userDto);
        return user;
    }
    @GetMapping
    public List<User> viewAll(){
        return service.findAll();
    }

    @PutMapping(path = "{id}")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto user){
        return service.updateById(id, user);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping(path = "{id}")
    public Optional<User> getOne(@PathVariable Integer id) throws ApiRequestException {
        Optional<User> user = service.getById(id);
        return user;
    }
//    @GetMapping(path = "{email}")
//    public Optional<User> getByEmail(@PathVariable String email, @RequestBody String email1) throws NotFoundException {
//        return service.findByEmail(email1);
//    }

}
