package com.example.FIR.Tracker.Controller;

import com.example.FIR.Tracker.Model.station;
import com.example.FIR.Tracker.Service.stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/station")
public class stationController {
    @Autowired
    stationService stationService;

    @PostMapping("/add")
    public ResponseEntity<station> add(@RequestBody station s) {
        station st = stationService.addStation(s);
        if(st == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/allstation")
    public ResponseEntity<List<station>> grtall() {
        return new ResponseEntity<>(stationService.allstation(), HttpStatus.OK);
    }

    @GetMapping("/station/{id}")
    public ResponseEntity<station> getByAid(@PathVariable BigInteger id) {
        station a = stationService.stationById(id);
        if(a == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(a, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<station> updateStation(@PathVariable BigInteger id, @RequestBody station stationData) {
        station existingStation = stationService.stationById(id);

        if (existingStation == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Update station fields
        if (stationData.getStationName() != null) {
            existingStation.setStationName(stationData.getStationName());
        }

        if (stationData.getStationIncharge() != null) {
            existingStation.setStationIncharge(stationData.getStationIncharge());
        }

        if (stationData.getStationInchargeId() != null) {
            existingStation.setStationInchargeId(stationData.getStationInchargeId());
        }

        if (stationData.getAddress() != null) {
            existingStation.setAddress(stationData.getAddress());
        }

        if (stationData.getPinCode() != 0) {
            existingStation.setPinCode(stationData.getPinCode());
        }

        if (stationData.getPhoneNo() != null) {
            existingStation.setPhoneNo(stationData.getPhoneNo());
        }

        if (stationData.getSEmail() != null) {
            existingStation.setSEmail(stationData.getSEmail());
        }

        station updatedStation = stationService.addStation(existingStation);
        return new ResponseEntity<>(updatedStation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStation(@PathVariable BigInteger id) {
        station existingStation = stationService.stationById(id);

        if (existingStation == null) {
            return new ResponseEntity<>("Station not found", HttpStatus.NOT_FOUND);
        }

        stationService.deleteStation(id);
        return new ResponseEntity<>("Station deleted successfully", HttpStatus.OK);
    }
}