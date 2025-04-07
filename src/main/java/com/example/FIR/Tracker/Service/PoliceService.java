package com.example.FIR.Tracker.Service;


import com.example.FIR.Tracker.Model.police;
import com.example.FIR.Tracker.Repo.PoliceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceService {
    @Autowired
    PoliceRepo policeRepo;
    public police addPolice(police p){
        return policeRepo.save(p);
    }
    public List<police> allpolice(){
        return policeRepo.findAll();
    }
    public  police policebyId(int id){
        return policeRepo.findByHrms(id);

    }

    public void deletePolice(int id) {
        police p = policeRepo.findByHrms(id);
        if (p != null) {
            policeRepo.delete(p);
        }
    }
    public void approve_false(int hrms){
        police p = policeRepo.findByHrms(hrms);
        p.setApproval(false);
        policeRepo.save(p);
    }

    public police suspendPolice(int id) {
        police officer = policebyId(id);
        if (officer != null) {
            officer.setApproval(false);
            return policeRepo.save(officer);
        }
        return null;
    }


}
