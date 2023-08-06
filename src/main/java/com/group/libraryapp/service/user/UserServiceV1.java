package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD

public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void updateUser(UserUpdateRequest request){
        if(userJdbcRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(request.getName(), request.getId());
=======
@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;
    public UserServiceV1(UserJdbcRepository userJdbcRepository){
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(),request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request){
        if(userJdbcRepository.isUserNotExitst(request.getId())){
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.getName(),request.getId());
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
    }

    public void deleteUser(String name){
        if(userJdbcRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }

<<<<<<< HEAD
        userJdbcRepository.deleteUserByName(name);
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }


    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsersResponses();
    }
=======
        userJdbcRepository.deleteUser(name);
    }





>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
}
