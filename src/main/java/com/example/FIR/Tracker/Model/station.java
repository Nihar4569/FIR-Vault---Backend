package com.example.FIR.Tracker.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "station")
public class station {

  @Id
  private BigInteger stationSid; // Station ID (matching the sid field in station model)

  @NotBlank
  private String stationName;

  @NotBlank
  private String address;

  @NotNull
  private int pinCode;

  @NotNull
  private BigInteger phoneNo;

  @NotBlank
  @Email
  private String sEmail;

  // Optional: Define the area under the station
  // private String jurisdictionArea;

  // Optional: Track officer count
  private int numberOfOfficers;

  private String pass;

  private boolean approval = false;

  @JsonProperty("StationInchargeId")
  private int StationInchargeId; // Added field to store the HRMS ID of the incharge

  public boolean isApproval() {
    return approval;
  }

  public void setApproval(boolean approval) {
    this.approval = approval;
  }

  public int getStationInchargeId() {
    return StationInchargeId;
  }

  public void setStationInchargeId(int stationInchargeId) {
    StationInchargeId = stationInchargeId;
  }

  //Setter & Getter

  public BigInteger getStationSid() {
    return stationSid;
  }

  public void setStationSid(BigInteger stationSid) {
    this.stationSid = stationSid;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPinCode() {
    return pinCode;
  }

  public void setPinCode(int pinCode) {
    this.pinCode = pinCode;
  }

  public BigInteger getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(BigInteger phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getsEmail() {
    return sEmail;
  }

  public void setsEmail(String sEmail) {
    this.sEmail = sEmail;
  }

  public int getNumberOfOfficers() {
    return numberOfOfficers;
  }

  public void setNumberOfOfficers(int numberOfOfficers) {
    this.numberOfOfficers = numberOfOfficers;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }
}