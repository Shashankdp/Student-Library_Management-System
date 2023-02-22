package com.example.Studentlibrarymanagement.Services;

import com.example.Studentlibrarymanagement.DTOs.IssueBookRequestDto;
import com.example.Studentlibrarymanagement.Enums.CardStatus;
import com.example.Studentlibrarymanagement.Enums.TransactionStatus;
import com.example.Studentlibrarymanagement.Models.Book;
import com.example.Studentlibrarymanagement.Models.Card;
import com.example.Studentlibrarymanagement.Models.Transactions;
import com.example.Studentlibrarymanagement.Repositories.BookRepository;
import com.example.Studentlibrarymanagement.Repositories.CardRepository;
import com.example.Studentlibrarymanagement.Repositories.TransactionRepository;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{

        int bookId=issueBookRequestDto.getBookId();
        int cardId=issueBookRequestDto.getCardId();

        //Get the Book entity and card Entity ?? why do we need this,
        //because we want to set the transaction attributes.

        Book book= bookRepository.findById(bookId).get();
        Card card=cardRepository.findById(cardId).get();

        //final goal is to make a transaction Entity,Set its attributes
        Transactions transaction=new Transactions();

        //setting the attributes

        transaction.setBook(book);
        transaction.setCard(card);
       // transaction.setTransactionId(UUID.randomUUID().toString()); //i assigned a transactionId in transaction class so there is no need of writing UUID....
        transaction.setIssuedOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);


        //attribute left is success/failure
        //check for validations
        if(book==null || book.isIssued()==true){
            //this time i will throw an exception
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);  //before throw an exception i need save trnx for db

            throw new Exception("Book is not available");
        }

        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);

            throw new Exception("Card is not valid");
        }


       //we have reached a success case now (if we did not go to "if" stmt)
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //set the attributes of book
        book.setIssued(true);
        //this is between the book and transaction : bidirectional
        List<Transactions> listOfTransactionForBook=book.getTransactions();
        listOfTransactionForBook.add(transaction);
        book.setTransactions(listOfTransactionForBook);

        //i need to make changes in the card,
        //Book and the card
        List<Book> issuedBooksForCard=card.getBookIssued();
        issuedBooksForCard.add(book);
        card.setBookIssued(issuedBooksForCard);

        //card and the transaction : bidirectional (in the parent class we are doing this)
        List<Transactions> transactionsListForCard=card.getTransactions();
        transactionsListForCard.add(transaction);
        card.setTransactions(transactionsListForCard);


        //save the parent
         // here i will only be saving the card, because card is the parent of both book and transaction.
        cardRepository.save(card);

        // by cascading : Book and transaction will be saved.

        return "Book issued";

    }
    public String getTransactions(int bookId,int cardId){
        List<Transactions> transactionsList=transactionRepository.getTransactionsForBookAndCard(bookId,cardId);
        String transactionId=transactionsList.get(0).getTransactionId();

        return transactionId;
    }

}
