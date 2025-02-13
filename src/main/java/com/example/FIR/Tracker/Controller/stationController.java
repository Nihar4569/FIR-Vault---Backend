package com.example.FIR.Tracker.Controller;


import com.example.FIR.Tracker.Model.station;
import com.example.FIR.Tracker.Service.stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class stationController {
    @Autowired
    stationService stationService;
    @PostMapping("/add")
    public ResponseEntity<station> add(@RequestBody station s)
    {
        station st = stationService.addStation(s);
        if(st == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        else
        {
            return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<station>> allStation(){
        return new ResponseEntity<>(stationService.allStation(),HttpStatus.OK);
    }



}
