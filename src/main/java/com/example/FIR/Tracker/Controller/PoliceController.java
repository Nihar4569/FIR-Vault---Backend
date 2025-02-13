package com.example.FIR.Tracker.Controller;

import com.example.FIR.Tracker.Model.police;
import com.example.FIR.Tracker.Service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



}
