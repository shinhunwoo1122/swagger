package com.example.swagger.controller;

import com.example.swagger.common.BaseResponse;
import com.example.swagger.common.CommonResponse;
import com.example.swagger.common.MetaData;
import com.example.swagger.model.dto.BookResponse;
import com.example.swagger.model.entity.Book;
import com.example.swagger.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(
        summary = "전체 도서 목록 조회",
        description = "DB저장된 book테이블에 저장된 모든 도서 정보 조회"
    )
    @GetMapping("/books")
    public ResponseEntity<BaseResponse> getAllBooks(){

        List<BookResponse> list = bookService.getAllBooks();

        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(MetaData.builder().result(true).code("200").message("정상 조회 하였습니다").build(), list));
    }


}
