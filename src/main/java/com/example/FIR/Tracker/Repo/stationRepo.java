package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.station;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface stationRepo extends MongoRepository<station, Integer> {
}
