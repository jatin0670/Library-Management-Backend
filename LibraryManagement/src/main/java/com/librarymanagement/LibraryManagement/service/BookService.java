package com.librarymanagement.LibraryManagement.service;

import com.librarymanagement.LibraryManagement.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
     public List<BookDTO> getAllBooks();

     public BookDTO getBookById(Long id);

     public BookDTO createBook(BookDTO bookdto);

     public  String deleteBook(Long id);
}
