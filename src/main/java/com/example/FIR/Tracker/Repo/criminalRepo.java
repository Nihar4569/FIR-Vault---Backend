package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.criminal;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface criminalRepo extends MongoRepository<criminal, BigInteger > {
    criminal findByAid(BigInteger id);
}
