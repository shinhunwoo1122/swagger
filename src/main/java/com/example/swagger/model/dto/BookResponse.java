package com.example.swagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    @Schema(description = "책 식별 아이디 PK", accessMode = READ_ONLY)
    private Long id;

    @Schema(description = "책 제목", requiredMode = REQUIRED, minLength = 2, example = "JAVA의 정석")
    private String title;

    @Schema(description = "책 저자", requiredMode = REQUIRED, example = "작가명")
    private String author;

    @Schema(description = "책 카테고리", requiredMode = NOT_REQUIRED, example = "GENERAL(일반서적), NOVEL(소설), COMIC(만화)")
    private String category;

    @Schema(description = "책출시년도", requiredMode = NOT_REQUIRED, example = ("2025"))
    private Integer publishedYear;

}
