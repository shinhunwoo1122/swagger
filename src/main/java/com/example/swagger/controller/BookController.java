package com.example.swagger.controller;

import com.example.swagger.common.BaseResponse;
import com.example.swagger.common.CommonResponse;
import com.example.swagger.common.MetaData;
import com.example.swagger.model.dto.BookRequest;
import com.example.swagger.model.dto.BookResponse;
import com.example.swagger.repository.BookRepository;
import com.example.swagger.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @FileName	: BookController.java
 * @Project		: swagger
 * @Date		: 2025-09-26
 * @Writter		: shinhunwoo
 *
 * @Description 도서 정보를 등록, 조회 검색하는 RESTful API Controller
 *
 */
@Tag(name = "도서관리 API", description = "도서 정보를 등록, 조회 검색하는 RESTful API")
@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;



    /**
     *  GET /api/books : 도서 목록을 전체 조회 함.
     * @return ResponseEntity<BaseResponse> , body : BookResponse
     */
    @Operation(
        summary = "전체 도서 목록 조회",
        description = "DB저장된 book테이블에 저장된 모든 도서 정보 조회"
    )
    @GetMapping("/books")
    public ResponseEntity<BaseResponse> getAllBooks(){
        List<BookResponse> list = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(MetaData.builder().result(true).code("200").message("정상 조회 하였습니다").build(), list));
    }

    /**
     *  POST /api/books : 도서 신규 등록.
     * @return ResponseEntity<BaseResponse> , body : BookResponse
     */
    @Operation(
            summary = "도서 신규 등록",
            description = "DB book 테이블에 데이터 등록",
            responses = {
                    @ApiResponse(responseCode = "201", description = "도서 등록 성공", content = @Content(schema = @Schema(implementation = BookResponse.class))),
                    @ApiResponse(responseCode = "400", description = "잘못된 요청 입니다.")
            }
    )
    @PostMapping("/books")
    public ResponseEntity<BaseResponse> createBook(@Valid @RequestBody BookRequest request){
        BookResponse response = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse<>(MetaData.builder().result(true).code("201").message("책 등록 완료").build(), response));
    }




}
