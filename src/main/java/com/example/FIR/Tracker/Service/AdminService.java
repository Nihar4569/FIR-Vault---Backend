package com.example.FIR.Tracker.Service;

import com.example.FIR.Tracker.Model.Admin;
import com.example.FIR.Tracker.Model.police;
import com.example.FIR.Tracker.Model.station;
import com.example.FIR.Tracker.Repo.AdminRepo;
import com.example.FIR.Tracker.Repo.PoliceRepo;
import com.example.FIR.Tracker.Repo.stationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PoliceRepo policeRepo;

    @Autowired
    private stationRepo stationRepo;

    // Admin CRUD
    public Admin registerAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin findByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

    // Police approval methods
    public List<police> getPendingPoliceApprovals() {
        // Assuming you've added a method in PoliceRepo to find by approval status
        return policeRepo.findByApprovalFalse();
    }

    public police approvePolice(int hrms) {
        police p = policeRepo.findByHrms(hrms);
        if (p != null) {
            p.setApproval(true);
            return policeRepo.save(p);
        }
        return null;
    }

    public void denyPolice(int hrms) {
        police p = policeRepo.findByHrms(hrms);
        if (p != null) {
            policeRepo.delete(p);
        }
    }

    // Station approval methods
    public List<station> getPendingStationApprovals() {
        // Assuming you've added a method in stationRepo to find by approval status
        return stationRepo.findByApprovalFalse();
    }

    public station approveStation(BigInteger sid) {
        station s = stationRepo.findByStationSid(sid);
        if (s != null) {
            s.setApproval(true);
            return stationRepo.save(s);
        }
        return null;
    }

    public void denyStation(BigInteger sid) {
        station s = stationRepo.findByStationSid(sid);
        if (s != null) {
            stationRepo.delete(s);
        }
    }
}