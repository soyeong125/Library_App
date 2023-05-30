package com.group.libraryapp.dto.book.request;

import org.springframework.web.bind.annotation.RestController;

public class BookCreateRequest {
    private String name;

    public String getName() {
        return name;
    }
}
