package com.example.swagger.service;

import com.example.swagger.model.dto.BookRequest;
import com.example.swagger.model.dto.BookResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();

    BookResponse createBook(@Valid BookRequest request);
}
