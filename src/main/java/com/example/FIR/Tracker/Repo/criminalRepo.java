package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.criminal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface criminalRepo extends MongoRepository<criminal, BigInteger> {
    criminal findByCriminalId(BigInteger id);
    List<criminal> findByStationId(BigInteger stationId);
    List<criminal> findByCriminalNameContainingIgnoreCase(String name);
    List<criminal> findByStatus(String status);
}