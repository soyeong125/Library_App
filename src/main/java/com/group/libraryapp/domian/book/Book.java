package com.group.libraryapp.domian.book;

import jakarta.persistence.*;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id = null;

    @Column(nullable = false)
    private String name;

    protected Book(){};

    public Book(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.",name));
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
