package com.badiagroup.Library.controller;

import com.badiagroup.Library.model.books;
import com.badiagroup.Library.model.loan_book;
import com.badiagroup.Library.model.loan_user;
import com.badiagroup.Library.model.loans;
import com.badiagroup.Library.model.users;
import com.badiagroup.Library.repository.books_repository;
import com.badiagroup.Library.repository.loans_repository;
import com.badiagroup.Library.repository.users_repository;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/loans")
public class loans_controller {

    @Autowired
    loans_repository loansRepository;

    @Autowired
    users_repository usersrepository;

    @Autowired
    books_repository booksrepository;

    // Create (POST) a new book
    @PostMapping
    public ResponseEntity<loans> createLoan(@RequestBody loans loan) {
        loans savedLoans = loansRepository.save(loan);
        return new ResponseEntity<>(savedLoans, HttpStatus.CREATED);
    }

    public class LoanResponse {
        private @Id long loan_id;

        @JsonProperty("full_name")
        private String fullName;

        @JsonProperty("book_title")
        private String bookTitle;

        @JsonProperty("loan_date")
        private Date loanDate;

        @JsonProperty("return_date")
        private Date returnDate;

        @JsonProperty("real_return_date")
        private Date realReturnDate;

        @JsonProperty("status")
        private String status;

        @JsonProperty("book_id")
        private Long bookId;

        @JsonProperty("user_id")
        private Long userId;

        // public LoanResponse() {
        // };

        public LoanResponse(long loanId, String fullName, String bookTitle, Long userId, Long bookId,
                Date loanDate, Date returnDate, Date realReturnDate, String status) {
            this.loan_id = loanId;
            this.fullName = fullName;
            this.bookTitle = bookTitle;
            this.userId = userId;
            this.bookId = bookId;
            this.loanDate = loanDate;
            this.returnDate = returnDate;
            this.realReturnDate = realReturnDate;
            this.status = status;
        }

        public long getId() {
            return this.loan_id;
        }

        public void setId(long loan_id) {
            this.loan_id = loan_id;
        }
    
        public String getFullName() {
            return fullName;
        }
    
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    
        public String getBookTitle() {
            return bookTitle;
        }
    
        public void setBookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
        }
    
        public Date getLoanDate() {
            return loanDate;
        }
    
        public void setLoanDate(Date loanDate) {
            this.loanDate = loanDate;
        }
    
        public Date getReturnDate() {
            return returnDate;
        }
    
        public void setReturnDate(Date returnDate) {
            this.returnDate = returnDate;
        }
    
        public Date getRealReturnDate() {
            return realReturnDate;
        }
    
        public void setRealReturnDate(Date realReturnDate) {
            this.realReturnDate = realReturnDate;
        }
    
        public String getStatus() {
            return status;
        }
    
        public void setStatus(String status) {
            this.status = status;
        }
    
        public Long getBookId() {
            return bookId;
        }
    
        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }
    
        public Long getUserId() {
            return userId;
        }
    
        public void setUserId(Long userId) {
            this.userId = userId;
        }

    }

    // Read (GET) all books
    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        List<loans> loans = loansRepository.findAll();
        List<LoanResponse> loanResponses = new ArrayList<>();

        for (loans loan : loans) {
            LoanResponse loanResponse = new LoanResponse(0, null, null, null, null, null, null, null, null);

            Long bookId = loan.getBook_id();
            books book = booksrepository.findById(bookId).orElse(null);
            String bookTitle = (book != null) ? book.getTitle() : "Book not found";
            loanResponse.setBookTitle(bookTitle);

            Long userId = loan.getUser_id();
            users user = usersrepository.findById(userId).orElse(null);
            String fullName = (user != null) ? user.getFirst_name() + " " + user.getLast_name() : "User not found";
            loanResponse.setFullName(fullName);

            loanResponse.setId(loan.getId());
            loanResponse.setLoanDate(loan.getLoan_date());
            loanResponse.setRealReturnDate(loan.getReal_return_date());
            loanResponse.setReturnDate(loan.getReturn_date());
            loanResponse.setStatus(loan.getStatus());
            loanResponse.setBookId(loan.getBook_id());
            loanResponse.setUserId(loan.getUser_id());

            loanResponses.add(loanResponse);
        }

        return new ResponseEntity<>(loanResponses, HttpStatus.OK);
    }

    // Read (GET) a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<loans> getLoansById(@PathVariable Long id) {
        Optional<loans> loanOptional = loansRepository.findById(id);
        if (loanOptional.isPresent()) {
            return new ResponseEntity<>(loanOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update (PUT) an existing book by ID
    @PutMapping("/{id}")
    public ResponseEntity<loans> updateLoans(@PathVariable Long id, @RequestBody loans updatedLoan) {
        Optional<loans> existingLoanOptional = loansRepository.findById(id);
        if (existingLoanOptional.isPresent()) {
            loans existingLoan = existingLoanOptional.get();
            existingLoan.setLoan_date(updatedLoan.getLoan_date());
            existingLoan.setReturn_date(updatedLoan.getReturn_date());
            existingLoan.setReal_return_date(updatedLoan.getReal_return_date());
            existingLoan.setStatus(updatedLoan.getStatus());
            existingLoan.setBook_id(updatedLoan.getBook_id());
            existingLoan.setUser_id(updatedLoan.getUser_id());

            loans savedLoan = loansRepository.save(existingLoan);
            return new ResponseEntity<>(savedLoan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loansRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
