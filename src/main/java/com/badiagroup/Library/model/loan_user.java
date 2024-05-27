package com.badiagroup.Library.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan_User")

public class loan_user {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private users user;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private loans loan;

    private @Id @GeneratedValue Long loan_user_id;

    public loan_user() {
    }

    public Long getId() {
        return this.loan_user_id;
    }

    public void setId(Long loan_user_id) {
        this.loan_user_id = loan_user_id;
    }


}
