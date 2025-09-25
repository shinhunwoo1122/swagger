package com.example.swagger.service.impl;

import com.example.swagger.model.dto.BookResponse;
import com.example.swagger.model.entity.Book;
import com.example.swagger.repository.BookRepository;
import com.example.swagger.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookResponse> getAllBooks() {

        List<Book> list = bookRepository.findAll();

        log.info("list >> {}", list);

        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

    /**
     * 단일 Entity를 Response DTO로 변환하는 메서드 (기존)
     */
    public BookResponse toDto(Book book) {
        if (book == null) return null;

        // DTO의 @Builder 패턴을 사용한다고 가정하고 코드를 작성합니다.
        // (Builder 패턴 사용 시 DTO에 @Builder, @Getter, @NoArgsConstructor, @AllArgsConstructor 조합 필요)
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .category(book.getCategory())
                .publishedYear(book.getPublishedYear())
                .build();
    }

}
