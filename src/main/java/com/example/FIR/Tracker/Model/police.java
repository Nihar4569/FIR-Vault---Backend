package com.example.FIR.Tracker.Model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    public BigInteger getStationId() {
        return stationId;
    }

    public void setStationId(BigInteger stationId) {
        this.stationId = stationId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @NotBlank
    private BigInteger stationId;

    @NotBlank
    private String password;

    private int firId;

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    private boolean approval = false;

}
