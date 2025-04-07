package com.example.FIR.Tracker.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "fir") // Fixed 'collation' to 'collection'
public class FIR {

    @Id
    private int firId;

    @NotNull // For LocalDate fields, use @NotNull instead of @NotBlank
    private LocalDate complainDate;

    @NotNull
    private LocalDate incidentDate;

    @NotBlank
    private String incidentLocation;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotBlank
    private String status = "submitted";
    //pending -> Assigned Police -> In Progress -> Resolved
    /*"submitted" - Initial state when FIR is first submitted
    "verified" - FIR has been verified by station
    "assigned" - FIR has been assigned to an officer
    "investigating" - Investigation in progress
    "evidence_collection" - Evidence is being collected
    "under_review" - Case is under review
    "resolved" - Case has been resolved
"closed" - Case has been closed */

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    private int officerId;

    @NotNull
    private BigInteger victimId;

    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    private Boolean close = false;
    @NotBlank
    private String description;

    public BigInteger getStationId() {
        return stationId;
    }

    public void setStationId(BigInteger stationId) {
        this.stationId = stationId;
    }

    @NotNull
    private BigInteger stationId;

}
