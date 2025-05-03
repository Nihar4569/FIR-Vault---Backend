package com.example.FIR.Tracker.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")


public class user {

    public BigInteger getAid() {
        return aid;
    }

    public String getPassword() {
        return password;
    }

    @Id
    private BigInteger aid;

    @NotBlank
    private String User_name;

    @NotNull
    private BigInteger phone_no;

    public BigInteger getPhone_no() {
        return phone_no;
    }

    @Email
    @NotBlank
    private  String  email;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate dob;

    @NotBlank
    private String gender;


    @NotBlank
    private String password;

//Setter & Getter


    public void setAid(BigInteger aid) {
        this.aid = aid;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public void setPhone_no(BigInteger phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
