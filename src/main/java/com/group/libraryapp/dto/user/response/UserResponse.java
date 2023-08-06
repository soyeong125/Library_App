package com.group.libraryapp.dto.user.response;

<<<<<<< HEAD
import com.group.libraryapp.domian.user.User;
=======
import com.group.libraryapp.domain.user.User;
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0

public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

<<<<<<< HEAD
    public UserResponse(long id, User user) {
        this.id = id;
=======
    public  UserResponse(User user){
        this.id = user.getId();
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
        this.name = user.getName();
        this.age = user.getAge();
    }

<<<<<<< HEAD
    public UserResponse(User user) {
        this.id = user.getId();
=======
    public UserResponse(long id, User user) {
        this.id = id;
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
        this.name = user.getName();
        this.age = user.getAge();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
