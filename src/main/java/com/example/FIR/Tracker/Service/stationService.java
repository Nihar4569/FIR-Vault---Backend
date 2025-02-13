package com.example.FIR.Tracker.Service;


import com.example.FIR.Tracker.Model.station;
import com.example.FIR.Tracker.Repo.stationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class stationService {
    @Autowired
    stationRepo stationRepo;
    public station addStation(station s)
    {
        return stationRepo.save(s);
    }
    public List<station> allStation(){
        return stationRepo.findAll();
    }

}
