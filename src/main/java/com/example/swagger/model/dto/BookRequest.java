package com.example.swagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @NotBlank(message = "책 제목은 필수 입력 항목입니다.")
    @Size(max = 255, message = "책 제목은 255자를 초과할 수 없습니다.")
    @Schema(description = "책 제목", example = "JAVA의정석")
    private String title;

    @NotBlank
    @Size(max = 255, message = "작가명은 255자를 초과 할 수 없습니다.")
    private String author;

    @NotBlank
    @Pattern(regexp = "GENERAL|NOVEL|COMIC", message = "카테고리 형식이 맞지 않습니다.")
    @Schema(description = "도서구분", example = "[GENERAL,NOVEL,COMIC]", allowableValues= {"GENERAL", "NOVEL", "COMIC"})
    private String category;

    @NotNull
    @Min(value = 1900, message = "1900년도 이후만 가능 합니다.")
    @Digits(integer = 4, fraction = 0, message = "출판년도는 4자리 숫자 합니다.")
    private Integer publishedYear;
}
