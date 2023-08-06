package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

<<<<<<< HEAD
    private final UserServiceV2 userServiceV2;

    public UserController(UserServiceV2 userServiceV2) {
        this.userServiceV2 = userServiceV2;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userServiceV2.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userServiceV2.getUsers();
=======
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService){
        this.userService = userService;
    }
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
<<<<<<< HEAD
        userServiceV2.updateUser(request);
=======
        userService.updateUser(request);
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
<<<<<<< HEAD
        userServiceV2.deleteUser(name);
    }
=======
        userService.deleteUser(name);
    }

>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
}
