package com.example.FIR.Tracker.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crime {
    @NotBlank
    private String crimeType; // e.g., "Theft", "Assault", etc.

    @NotBlank
    private String description;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate crimeDate;

    private String location;

    private int firId; // Associated FIR ID if any

    @NotBlank
    private String status; // "Pending", "Under Trial", "Convicted", "Acquitted"

    private String punishment; // If convicted

    private LocalDate convictionDate;

    //Setter & Getter


    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(LocalDate crimeDate) {
        this.crimeDate = crimeDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFirId() {
        return firId;
    }

    public void setFirId(int firId) {
        this.firId = firId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public LocalDate getConvictionDate() {
        return convictionDate;
    }

    public void setConvictionDate(LocalDate convictionDate) {
        this.convictionDate = convictionDate;
    }
}