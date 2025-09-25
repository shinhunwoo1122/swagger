package com.example.swagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @Schema(description = "책 제목", example = "JAVA의정석")
    private String title;

    @Schema(description = "책 저자", example = "작가명")
    private String author;

}
