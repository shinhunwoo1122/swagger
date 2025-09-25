package com.example.swagger.service;

import com.example.swagger.model.dto.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
}
