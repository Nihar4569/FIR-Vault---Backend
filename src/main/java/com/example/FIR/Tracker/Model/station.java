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
  private BigInteger sid;//Station id

  @NotBlank
  private String station_name;

  @NotBlank
  private String Station_Incharge;

  @NotBlank
  private String address;

  @NotNull
  private int pin_code;

  @NotNull
   private BigInteger phone_no;

  @NotBlank
  @Email
  private String Email;

  private String jurisdictionArea; // Optional: Define the area under the station

  private int numberOfOfficers; // Optional: Track officer count

}
