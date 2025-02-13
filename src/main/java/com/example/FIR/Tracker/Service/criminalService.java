package com.example.FIR.Tracker.Service;


import com.example.FIR.Tracker.Model.criminal;
import com.example.FIR.Tracker.Repo.criminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class criminalService {
    @Autowired
    criminalRepo criminalRepo;

    public criminal addcriminal(criminal c){
          return  criminalRepo.save(c);
    }
    public List<criminal> allcriminal(){
        return criminalRepo.findAll();
    }
   public criminal criminalById(BigInteger id){
        return criminalRepo.findByAid(id);
   }
}
