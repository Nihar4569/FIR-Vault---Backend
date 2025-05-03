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
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "criminal")
public class criminal {
    @Id
    private BigInteger criminalId; // Changed from aid

    @NotBlank
    private String criminalName; // Fixed typo from ceiminalName

    @NotNull
    private BigInteger phone_no;

    @Email
    private String email; // Made optional

    @NotBlank
    private String gender;

    @NotBlank
    private String address;

    // New fields
    private int age;
    private String identificationMarks;

    @NotBlank
    private String status;  // e.g., "Arrested", "Wanted", "Released", "In Trial", "Convicted"

    private String photoUrl;  // URL for the criminal's image

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate recordCreatedAt = LocalDate.now();  // Auto-generated timestamp

    // List of crimes committed - each crime can be a separate object
    private List<Crime> crimes;

    // Station that registered the criminal
    @NotNull
    private BigInteger stationId;

    // Officer who registered the criminal
    private int registeredById;

//Setter & Getter


    public BigInteger getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(BigInteger criminalId) {
        this.criminalId = criminalId;
    }

    public String getCriminalName() {
        return criminalName;
    }

    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }

    public BigInteger getPhone_no() {
        return phone_no;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentificationMarks() {
        return identificationMarks;
    }

    public void setIdentificationMarks(String identificationMarks) {
        this.identificationMarks = identificationMarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public LocalDate getRecordCreatedAt() {
        return recordCreatedAt;
    }

    public void setRecordCreatedAt(LocalDate recordCreatedAt) {
        this.recordCreatedAt = recordCreatedAt;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public BigInteger getStationId() {
        return stationId;
    }

    public void setStationId(BigInteger stationId) {
        this.stationId = stationId;
    }

    public int getRegisteredById() {
        return registeredById;
    }

    public void setRegisteredById(int registeredById) {
        this.registeredById = registeredById;
    }
}