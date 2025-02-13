package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.FIR;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirRepo extends MongoRepository<FIR,Integer> {
    FIR findByFirId(int id);

}
