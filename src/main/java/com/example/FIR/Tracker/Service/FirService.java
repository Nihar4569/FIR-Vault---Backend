package com.example.FIR.Tracker.Service;

import com.example.FIR.Tracker.Model.FIR;
import com.example.FIR.Tracker.Repo.FirRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirService {
    @Autowired
    FirRepo firRepo;

    public FIR addFir(FIR fir){
        return firRepo.save(fir);
    }

    public List<FIR> allFir(){
        return firRepo.findAll();
    }

    public FIR getfir(int id){
        return firRepo.findByFirId(id);
    }

    public FIR assignOfficer(int firId, int OfficerId){
        FIR fir = firRepo.findByFirId(firId);
        if(fir==null){
            return null;
        }
        else {
            fir.setOfficerId(OfficerId);
            // Also update status to "assigned"
            fir.setStatus("assigned");
        }
        firRepo.save(fir);
        return fir;
    }

    public FIR closeFir(int firId){
        FIR fir = firRepo.findByFirId(firId);
        if(fir == null){
            return null;
        }
        else {
            fir.setClose(!fir.getClose());
            // Also update status to "resolved"
            fir.setStatus("resolved");
        }
        firRepo.save(fir);
        return fir;
    }

    public FIR updateStatus(int firId, String status){
        FIR fir = firRepo.findByFirId(firId);
        if(fir == null){
            return null;
        }
        fir.setStatus(status);
        firRepo.save(fir);
        return fir;
    }
}