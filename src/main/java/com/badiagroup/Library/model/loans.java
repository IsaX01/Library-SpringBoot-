package com.badiagroup.Library.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.badiagroup.Library.repository.books_repository;
import com.badiagroup.Library.repository.users_repository;

@Entity
@Table(name = "Loans")

public class loans {


    private @Id @GeneratedValue long loan_id;
    private Date loan_date;
    private Date return_date;
    private Date real_return_date;
    private String status;
    private Long book_id;
    private Long user_id;



    public loans() {
    }
    

    public loans(Long user_id, Long book_id, Date loan_date, Date return_date, Date real_return_date, String status) {
        // this.bookTitle = bookTitle;
        // this.fullName = fullName;
        this.user_id = user_id;
        this.book_id = book_id;
        this.loan_date = loan_date;
        this.return_date = return_date;
        this.real_return_date = real_return_date;
        this.status = status;
    }

    public long getId() {
        return this.loan_id;
    }

    public void setId(long loan_id) {
        this.loan_id = loan_id;
    }
       
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }


    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Date getReal_return_date() {
        return real_return_date;
    }

    public void setReal_return_date(Date real_return_date) {
        this.real_return_date = real_return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
