package com.example.FIR.Tracker.Service;


import com.example.FIR.Tracker.Model.user;
import com.example.FIR.Tracker.Repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class userService {
    @Autowired
    userRepo userRepo;
  public user adduser(user aid ){
      return userRepo.save(aid);
  }
  public List<user> alluser(){
      return userRepo.findAll();
  }
  public user userbyId(BigInteger id){
      return userRepo.findByAid(id);
  }
}
