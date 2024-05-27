package com.badiagroup.Library.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Loan_Book")

public class loan_book {

    @ManyToOne
    @JoinColumn(name = "book_id")
    private books book;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private loans loan;

    private @Id @GeneratedValue Long loan_book_id;

    public loan_book() {
    }


    public long getId() {
        return this.loan_book_id;
    }

    public void setId(long loan_book_id) {
        this.loan_book_id = loan_book_id;
    }

   
}
