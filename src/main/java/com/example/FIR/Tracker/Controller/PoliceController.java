package com.example.FIR.Tracker.Controller;

import com.example.FIR.Tracker.Model.police;
import com.example.FIR.Tracker.Service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/police")
public class PoliceController {
    @Autowired
    PoliceService policeService;

    @PostMapping("/add")
    public ResponseEntity<police> add(@RequestBody police p){
        police np = policeService.addPolice(p);
        if(np==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        else
            return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
    }
    @GetMapping("/allpolice")
    public ResponseEntity<List<police>> getallpolice(){return new ResponseEntity<>(policeService.allpolice(),HttpStatus.OK);}

    @GetMapping("/police/{id}")
    public ResponseEntity<police> FindByhrms(@PathVariable int id){
      police p = policeService.policebyId(id);
      if(p==null){
          return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
      }
      else
          return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<police> updatePolice(@PathVariable int id, @RequestBody police policeData) {
        police existingPolice = policeService.policebyId(id);

        if (existingPolice == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Update police fields
        if (policeData.getName() != null) {
            existingPolice.setName(policeData.getName());
        }

        if (policeData.getEmail() != null) {
            existingPolice.setEmail(policeData.getEmail());
        }

        if (policeData.getPhone_no() != null) {
            existingPolice.setPhone_no(policeData.getPhone_no());
        }

        if (policeData.getGender() != null) {
            existingPolice.setGender(policeData.getGender());
        }

        if (policeData.getPosition() != null) {
            existingPolice.setPosition(policeData.getPosition());
        }

        if (policeData.getStationId() != null) {
            existingPolice.setStationId(policeData.getStationId());
        }

        police updatedPolice = policeService.addPolice(existingPolice);
        return new ResponseEntity<>(updatedPolice, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePolice(@PathVariable int id) {
        police existingPolice = policeService.policebyId(id);

        if (existingPolice == null) {
            return new ResponseEntity<>("Police officer not found", HttpStatus.NOT_FOUND);
        }

        policeService.deletePolice(id);
        return new ResponseEntity<>("Police officer deleted successfully", HttpStatus.OK);
    }



}
