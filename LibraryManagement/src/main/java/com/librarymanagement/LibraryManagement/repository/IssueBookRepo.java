package com.librarymanagement.LibraryManagement.repository;

import com.librarymanagement.LibraryManagement.entity.IssueBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepo extends JpaRepository<IssueBookEntity, Long> {
}
