package com.badiagroup.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class users {
    private @Id @GeneratedValue long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
    private Integer user_type_id;
    private String profile_picture;
    private String status;

    public users() {
    }

    public users(String first_name, String last_name, String email, String password, String address, Integer user_type_id,
            String profile_picture, String status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.user_type_id = user_type_id;
        this.profile_picture = profile_picture;
        this.status = status;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name){
       this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name){
       this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email){
       this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password){
       this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address){
       this.address = address;
    }

    public Integer getUser_type_id() {
        return this.user_type_id;
    }

    public void setUser_type_id(Integer user_type_id){
       this.user_type_id = user_type_id;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture){
       this.profile_picture = profile_picture;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status){
       this.status = status;
    }
}
