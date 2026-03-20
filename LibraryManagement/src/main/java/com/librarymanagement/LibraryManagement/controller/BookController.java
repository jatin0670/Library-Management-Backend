package com.librarymanagement.LibraryManagement.controller;

import com.librarymanagement.LibraryManagement.dto.BookDTO;
import com.librarymanagement.LibraryManagement.entity.BookEntity;
import com.librarymanagement.LibraryManagement.repository.BookRepo;
import com.librarymanagement.LibraryManagement.service.imp.BookServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class BookController {

   private final BookServiceImp bookserviceimp;


    @GetMapping("/allbooks")
    public List<BookDTO> getallbooks(){
      List<BookDTO> bookentity =  bookserviceimp.getAllBooks();
      return bookentity;
    }

    @GetMapping("/allbooks/{id}")
    public BookDTO getBookById(@PathVariable Long id){
        return bookserviceimp.getBookById(id);

    }

    @PostMapping("/book")
    public BookDTO postBook(@RequestBody BookDTO bookdto){
         return bookserviceimp.createBook(bookdto);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable Long id){
          bookserviceimp.deleteBook(id);
          return "book deleted id: "+id;
    }



}
