package com.example.Studentlibrarymanagement.Controllers;

import com.example.Studentlibrarymanagement.DTOs.IssueBookRequestDto;
import com.example.Studentlibrarymanagement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
           try{
               return transactionService.issueBook(issueBookRequestDto);
           }
           catch(Exception e){
               return e.getMessage();
           }
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionInfo(@RequestParam("bookId") Integer bookId,@RequestParam("cardId") Integer cardId){
        return transactionService.getTransactions(bookId,cardId);
    }
}
