package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.station;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface stationRepo extends MongoRepository<station, Integer> {
    station findByStationSid(BigInteger id);
    List<station> findByApprovalFalse();

}
