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
  private String StationIncharge;

  @NotBlank
  private String address;

  @NotNull
  private int pinCode;

  @NotNull
   private BigInteger phoneNo;

  @NotBlank
  @Email
  private String sEmail;

//  private String jurisdictionArea; // Optional: Define the area under the station

  private int numberOfOfficers; // Optional: Track officer count

  private String pass;

  public boolean isApproval() {
    return approval;
  }

  public void setApproval(boolean approval) {
    this.approval = approval;
  }

  private boolean approval = false;

  public BigInteger getStationInchargeId() {
    return StationInchargeId;
  }

  public void setStationInchargeId(BigInteger stationInchargeId) {
    StationInchargeId = stationInchargeId;
  }

  private BigInteger StationInchargeId;

}
