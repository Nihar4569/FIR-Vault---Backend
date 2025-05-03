package com.example.FIR.Tracker.Controller;

import com.example.FIR.Tracker.Model.Crime;
import com.example.FIR.Tracker.Model.criminal;
import com.example.FIR.Tracker.Service.criminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/criminal")
public class criminalController {
    @Autowired
    private criminalService criminalService;

    @PostMapping("/add")
    public ResponseEntity<criminal> addCriminal(@RequestBody criminal criminal) {
        criminal cm = criminalService.addcriminal(criminal);
        if(cm == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(cm, HttpStatus.CREATED);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<criminal>> getAll() {
        return new ResponseEntity<>(criminalService.allcriminal(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<criminal> getById(@PathVariable BigInteger id) {
        criminal c = criminalService.criminalById(id);
        if(c == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(c, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<criminal> updateCriminal(@PathVariable BigInteger id, @RequestBody criminal criminalData) {
        criminal existingCriminal = criminalService.criminalById(id);

        if (existingCriminal == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Update criminal fields
        if (criminalData.getCriminalName() != null) {
            existingCriminal.setCriminalName(criminalData.getCriminalName());
        }

        if (criminalData.getPhone_no() != null) {
            existingCriminal.setPhone_no(criminalData.getPhone_no());
        }

        if (criminalData.getEmail() != null) {
            existingCriminal.setEmail(criminalData.getEmail());
        }

        if (criminalData.getAddress() != null) {
            existingCriminal.setAddress(criminalData.getAddress());
        }

        if (criminalData.getAge() > 0) {
            existingCriminal.setAge(criminalData.getAge());
        }

        if (criminalData.getIdentificationMarks() != null) {
            existingCriminal.setIdentificationMarks(criminalData.getIdentificationMarks());
        }

        if (criminalData.getStatus() != null) {
            existingCriminal.setStatus(criminalData.getStatus());
        }

        if (criminalData.getPhotoUrl() != null) {
            existingCriminal.setPhotoUrl(criminalData.getPhotoUrl());
        }

        if (criminalData.getCrimes() != null) {
            existingCriminal.setCrimes(criminalData.getCrimes());
        }

        criminal updatedCriminal = criminalService.addcriminal(existingCriminal);
        return new ResponseEntity<>(updatedCriminal, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCriminal(@PathVariable BigInteger id) {
        criminal existingCriminal = criminalService.criminalById(id);

        if (existingCriminal == null) {
            return new ResponseEntity<>("Criminal not found", HttpStatus.NOT_FOUND);
        }

        criminalService.deleteCriminal(id);
        return new ResponseEntity<>("Criminal deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/station/{stationId}")
    public ResponseEntity<List<criminal>> getCriminalsByStation(@PathVariable BigInteger stationId) {
        List<criminal> criminals = criminalService.findByStationId(stationId);
        return new ResponseEntity<>(criminals, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<criminal>> searchCriminals(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String status) {
        List<criminal> criminals = criminalService.searchCriminals(name, status);
        return new ResponseEntity<>(criminals, HttpStatus.OK);
    }

    @PostMapping("/{criminalId}/addCrime")
    public ResponseEntity<criminal> addCrime(@PathVariable BigInteger criminalId, @RequestBody Crime crime) {
        criminal updatedCriminal = criminalService.addCrimeToCriminal(criminalId, crime);
        if (updatedCriminal == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCriminal, HttpStatus.OK);
    }
}