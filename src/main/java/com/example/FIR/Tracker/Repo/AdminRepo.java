package com.example.FIR.Tracker.Repo;

import com.example.FIR.Tracker.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
}