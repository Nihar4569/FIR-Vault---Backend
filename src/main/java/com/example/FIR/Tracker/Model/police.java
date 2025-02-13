package com.example.FIR.Tracker.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "police")
public class police {

    @Id
    private int hrms;

    @NotBlank
    private String email;

    @NotBlank
    private  String name;

    @NotNull
    private BigInteger phone_no;

    @NotBlank
    private String gender;

    @NotBlank
    private String position;

    @NotBlank
    private String stationName;

    @NotBlank
    private String password;

    private int firId;
}

