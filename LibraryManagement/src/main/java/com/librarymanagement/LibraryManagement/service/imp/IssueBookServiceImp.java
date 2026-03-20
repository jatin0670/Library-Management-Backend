package com.librarymanagement.LibraryManagement.service.imp;

import com.librarymanagement.LibraryManagement.dto.IssueBookDTO;
import com.librarymanagement.LibraryManagement.entity.IssueBookEntity;
import com.librarymanagement.LibraryManagement.repository.IssueBookRepo;
import com.librarymanagement.LibraryManagement.service.IssusBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class IssueBookServiceImp implements IssusBookService {

    public final IssueBookRepo issuebookrepo;

    @Override
    public List<IssueBookDTO> getAllIsssue() {
        List<IssueBookEntity> issuebookentity = issuebookrepo.findAll();
        List<IssueBookDTO> issuebookdto = issuebookentity.stream().map(issueBookEntity -> new IssueBookDTO(issueBookEntity.getId(), issueBookEntity.getName(), issueBookEntity.getBook(), issueBookEntity.getIssueDate(), issueBookEntity.getReturnDate())).toList();
        return issuebookdto;
    }

    @Override
    public IssueBookDTO createIssueBook(IssueBookDTO issuebookdto) {
        IssueBookEntity issuebookentity = new IssueBookEntity(null, issuebookdto.getName(), issuebookdto.getBook(), issuebookdto.getIssueDate(), issuebookdto.getReturnDate());
        IssueBookEntity saved = issuebookrepo.save(issuebookentity);
        IssueBookDTO savedissuedto = new IssueBookDTO(saved.getId(), saved.getName(), saved.getBook(), saved.getIssueDate(), saved.getReturnDate());
        return savedissuedto;
    }

    @Override
    public void deleteIssueBook(Long id) {
        issuebookrepo.deleteById(id);
    }
}
