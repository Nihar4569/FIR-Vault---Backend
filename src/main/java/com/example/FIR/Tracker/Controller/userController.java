package com.example.FIR.Tracker.Controller;


import com.example.FIR.Tracker.Model.user;
import com.example.FIR.Tracker.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/user")

public class userController {
    @Autowired
    userService userService;

    @PostMapping("/add")
    public ResponseEntity<user> adduser(@RequestBody user aid) {
        user mp = userService.adduser(aid);
        if (mp == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(aid, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/alluser")
    public ResponseEntity<List<user>> getall(){
            return new ResponseEntity<>(userService.alluser(),HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<user> getByAid(@PathVariable BigInteger id){
        user u = userService.userbyId(id);
        if(u==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            return new ResponseEntity<>(u,HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable BigInteger id) {
        user existingUser = userService.userbyId(id);

        if (existingUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<user> login(@RequestBody user obj){
//        user User = userService.findByPh(obj.getPhone_no());
//        if(User==null){
//            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//        }
//        else if(obj.getPassword() != User.getPassword()){
//            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
//        }else{
//            return new ResponseEntity<>(User,HttpStatus.OK);
//        }
//    }


}
