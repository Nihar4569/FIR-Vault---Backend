package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface userRepo extends MongoRepository<user, BigInteger > {
    user findByAid(BigInteger id);
//    user findByPhone_no(BigInteger phone_no);
}
