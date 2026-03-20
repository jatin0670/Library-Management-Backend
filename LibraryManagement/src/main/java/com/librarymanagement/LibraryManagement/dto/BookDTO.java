package com.librarymanagement.LibraryManagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Long qty;
    private Long available;

}
