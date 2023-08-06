package com.group.libraryapp.service.user;

<<<<<<< HEAD
import com.group.libraryapp.domian.user.User;
import com.group.libraryapp.domian.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
=======
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
<<<<<<< HEAD

    private UserRepository userRepository;
=======
    private final UserRepository userRepository;
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
<<<<<<< HEAD
        userRepository.save(new User(request.getName(),request.getAge()));
    }
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
=======
        User u = userRepository.save(new User(request.getName(),request.getAge()));
    }
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId())
<<<<<<< HEAD
        .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
=======
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user);
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
    }
    @Transactional
    public void deleteUser(String name){
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
<<<<<<< HEAD

        userRepository.delete(user);
    }

=======
        userRepository.delete(user);
//        if(!userRepository.existsByName(name)){
//            throw new IllegalArgumentException();
//        }
//        User user = userRepository.findByName(name);
//        userRepository.delete(user);

    }
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
}
