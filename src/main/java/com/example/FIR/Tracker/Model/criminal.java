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
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "criminal")
public class criminal {
    @Id
    private BigInteger aid;

    @NotBlank
    private String ceiminalName;

    @NotNull
    private BigInteger phone_no;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String gender;

    @NotBlank
    private String crimeCommitted;

    @NotBlank
    private String status;  // e.g., "Arrested", "Wanted", "Released"

    private String photoUrl;  // URL for the criminal's image

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date recordCreatedAt = new Date();  // Auto-generated timestamp



}
