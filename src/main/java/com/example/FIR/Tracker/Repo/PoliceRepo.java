package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.police;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PoliceRepo extends MongoRepository<police,Integer> {
    police findByHrms(int id);
}
