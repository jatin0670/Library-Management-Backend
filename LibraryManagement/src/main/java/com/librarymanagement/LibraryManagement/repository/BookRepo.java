package com.librarymanagement.LibraryManagement.repository;

import com.librarymanagement.LibraryManagement.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {
}
