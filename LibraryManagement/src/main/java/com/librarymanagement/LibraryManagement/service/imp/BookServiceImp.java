package com.librarymanagement.LibraryManagement.service.imp;

import com.librarymanagement.LibraryManagement.dto.BookDTO;
import com.librarymanagement.LibraryManagement.entity.BookEntity;
import com.librarymanagement.LibraryManagement.repository.BookRepo;
import com.librarymanagement.LibraryManagement.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImp implements BookService {

    private final BookRepo bookrepo;

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookentity =  bookrepo.findAll();
        List<BookDTO> bookdto = bookentity
                .stream()
                .map(bookEntity -> new BookDTO(bookEntity.getId(),
                        bookEntity.getTitle(),
                        bookEntity.getAuthor(),
                        bookEntity.getQty(),
                        bookEntity.getAvailable())).toList();

        return bookdto;
    }

    @Override
    public BookDTO getBookById(Long id) {
        BookEntity bookentity = bookrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("data not found on this id " + id));
        BookDTO bookdto = new BookDTO(bookentity.getId(),
                bookentity.getTitle(),
                bookentity.getAuthor(),
                bookentity.getQty(),
                bookentity.getAvailable());

        return bookdto;
    }

    @Override
    public BookDTO createBook(BookDTO bookdto) {
        BookEntity bookentity = new BookEntity(null,
                bookdto.getTitle(),
                bookdto.getAuthor(),
                bookdto.getQty(),
                bookdto.getAvailable());

        BookEntity saved = bookrepo.save(bookentity);
        BookDTO savedBookdto = new BookDTO(saved.getId(),
                saved.getTitle(),
                saved.getAuthor(),
                saved.getQty(),
                saved.getAvailable());

        return savedBookdto;
    }

    @Override
    public String deleteBook(Long id) {
        bookrepo.deleteById(id);
        return "Book deleted in service";
    }

}
