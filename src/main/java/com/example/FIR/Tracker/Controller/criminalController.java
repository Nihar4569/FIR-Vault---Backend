package com.example.FIR.Tracker.Controller;


import com.example.FIR.Tracker.Model.criminal;
import com.example.FIR.Tracker.Service.criminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/criminal")
public class criminalController {
 @Autowired
    private criminalService criminalService;
   @PostMapping("/addCriminal")
    public ResponseEntity<criminal> addCriminal(@RequestBody criminal aid){

       criminal cm = criminalService.addcriminal(aid);
           if(cm == null){
               return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
           }else
           {
               return  new ResponseEntity<>(aid,HttpStatus.ACCEPTED);
           }
   }
   @GetMapping("/allCriminal")
    public  ResponseEntity<List<criminal>> getall(){
       return new ResponseEntity<>(criminalService.allcriminal(),HttpStatus.OK);
   }
   @GetMapping("/criminal/{id}")
    public ResponseEntity<criminal> getById(@PathVariable  BigInteger id){
       criminal c = criminalService.criminalById(id);
       if(c==null){
           return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
       }
       else
       {
           return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
       }
   }


}
