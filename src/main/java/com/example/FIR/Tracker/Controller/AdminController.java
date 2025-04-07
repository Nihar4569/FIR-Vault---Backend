package com.example.FIR.Tracker.Controller;

import com.example.FIR.Tracker.Model.Admin;
import com.example.FIR.Tracker.Model.police;
import com.example.FIR.Tracker.Model.station;
import com.example.FIR.Tracker.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.registerAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Admin admin = adminService.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/pending-police")
    public ResponseEntity<List<police>> getPendingPoliceApprovals() {
        return new ResponseEntity<>(adminService.getPendingPoliceApprovals(), HttpStatus.OK);
    }

    @PostMapping("/approve-police/{hrms}")
    public ResponseEntity<police> approvePolice(@PathVariable int hrms) {
        police p = adminService.approvePolice(hrms);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deny-police/{hrms}")
    public ResponseEntity<?> denyPolice(@PathVariable int hrms) {
        adminService.denyPolice(hrms);
        return new ResponseEntity<>("Police officer registration denied", HttpStatus.OK);
    }

    @GetMapping("/pending-stations")
    public ResponseEntity<List<station>> getPendingStationApprovals() {
        return new ResponseEntity<>(adminService.getPendingStationApprovals(), HttpStatus.OK);
    }

    @PostMapping("/approve-station/{sid}")
    public ResponseEntity<station> approveStation(@PathVariable BigInteger sid) {
        station s = adminService.approveStation(sid);
        if (s != null) {
            return new ResponseEntity<>(s, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deny-station/{sid}")
    public ResponseEntity<?> denyStation(@PathVariable BigInteger sid) {
        adminService.denyStation(sid);
        return new ResponseEntity<>("Station registration denied", HttpStatus.OK);
    }
}