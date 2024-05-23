package com.badiagroup.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class loans {

    private @Id @GeneratedValue long id;
    private Integer user_id;
    private Integer book_id;
    private Date load_date;
    private Date return_date;
    private Date real_return_date;
    private String status;

    public loans() {
    }

    public loans(Integer user_id, Integer book_id, Date load_date, Date return_date, Date real_return_date, String status) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.load_date = load_date;
        this.return_date = return_date;
        this.real_return_date = real_return_date;
        this.status = status;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Date getLoad_date() {
        return load_date;
    }

    public void setLoad_date(Date load_date) {
        this.load_date = load_date;
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
