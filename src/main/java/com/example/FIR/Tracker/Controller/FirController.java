package com.example.FIR.Tracker.Controller;

import com.example.FIR.Tracker.Model.FIR;
import com.example.FIR.Tracker.Service.FirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/fir")
public class FirController {
    @Autowired
    private FirService firService;

    @PostMapping("/addfir")
    public ResponseEntity<FIR> addFir(@RequestBody FIR fir){
        FIR newFir = firService.addFir(fir);
        if (newFir == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newFir, HttpStatus.CREATED);
    }

    @GetMapping("/allfir")
    public ResponseEntity<List<FIR>> getAllFirs(){
        return new ResponseEntity<>(firService.allFir(), HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<FIR> findbyid(@PathVariable int id){
        FIR fir = firService.getfir(id);
        if(fir==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
        else
            return new ResponseEntity<>(fir,HttpStatus.OK);

    }


    @PostMapping("/assignofficer/{firId}/{officerId}")
    public ResponseEntity<FIR> assignofficer(@PathVariable int firId, @PathVariable int officerId){
        FIR fir = firService.assignOfficer(firId,officerId);
        if(fir==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
        else
            return new ResponseEntity<>(fir,HttpStatus.OK);
    }

    @PostMapping("/close/{firId}")
    public ResponseEntity<FIR> closeFir(@PathVariable int firId){
        FIR fir = firService.closeFir(firId);
        if(fir==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }else {
            return new ResponseEntity<>(fir,HttpStatus.OK);
        }
    }

    @PostMapping("/update-status/{firId}/{status}")
    public ResponseEntity<FIR> updateStatus(@PathVariable int firId, @PathVariable String status){
        FIR fir = firService.updateStatus(firId, status);
        if(fir==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }else {
            return new ResponseEntity<>(fir,HttpStatus.OK);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FIR> updateFIR(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        FIR fir = firService.getfir(id);
        if (fir == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Apply the updates
        if (updates.containsKey("criminalId")) {
            fir.setCriminalId(new BigInteger(updates.get("criminalId").toString()));
        }

        // Add other fields as needed

        FIR updatedFir = firService.addFir(fir);
        return new ResponseEntity<>(updatedFir, HttpStatus.OK);
    }
}
