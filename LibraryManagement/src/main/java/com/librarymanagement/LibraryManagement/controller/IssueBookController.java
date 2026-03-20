package com.librarymanagement.LibraryManagement.controller;

import com.librarymanagement.LibraryManagement.dto.IssueBookDTO;
import com.librarymanagement.LibraryManagement.service.IssusBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class IssueBookController {

   public final IssusBookService issuebookservice;

    @GetMapping("allissuebooks")
    public List<IssueBookDTO> getAllIssue(){
        return issuebookservice.getAllIsssue();
    }

    @PostMapping("issuebook")
    public IssueBookDTO postIssueBook(@RequestBody IssueBookDTO issuebookdto){
        return issuebookservice.createIssueBook(issuebookdto);
    }

    @DeleteMapping("issuebook/{id}")
    public String deleteIssueBook(@PathVariable Long id){
        issuebookservice.deleteIssueBook(id);
         return "Issued book deleted";
    }
}
