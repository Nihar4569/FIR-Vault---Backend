package com.example.FIR.Tracker.Service;


import com.example.FIR.Tracker.Model.police;
import com.example.FIR.Tracker.Model.station;
import com.example.FIR.Tracker.Model.user;
import com.example.FIR.Tracker.Repo.stationRepo;
import com.example.FIR.Tracker.Repo.PoliceRepo;
import com.example.FIR.Tracker.Repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class stationService {
    @Autowired
    stationRepo stationRepo;

    @Autowired
    PoliceRepo policeRepo;

    @Autowired
    userRepo userRepo;
    public station addStation(station s)
    {
        return stationRepo.save(s);
    }
    public List<station> allstation(){return stationRepo.findAll();}
    public station stationById(BigInteger id){return stationRepo.findByStationSid(id);}
    public void deleteStation(BigInteger id) {
        station s = stationRepo.findByStationSid(id);
        if (s != null) {
            stationRepo.delete(s);
        }
    }





}

