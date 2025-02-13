package com.example.FIR.Tracker.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    @NotBlank
    private String status;

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    private int officerId;

    @NotNull
    private int victimId;

    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    private Boolean close = false;
}
