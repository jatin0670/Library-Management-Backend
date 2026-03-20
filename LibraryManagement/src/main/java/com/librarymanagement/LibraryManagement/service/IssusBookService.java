package com.librarymanagement.LibraryManagement.service;

import com.librarymanagement.LibraryManagement.dto.IssueBookDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IssusBookService {

    public List<IssueBookDTO> getAllIsssue();

    public IssueBookDTO createIssueBook(IssueBookDTO issuebookdto);

    public void deleteIssueBook(Long id);
}
