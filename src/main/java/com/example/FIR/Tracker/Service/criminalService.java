package com.example.FIR.Tracker.Service;

import com.example.FIR.Tracker.Model.Crime;
import com.example.FIR.Tracker.Model.criminal;
import com.example.FIR.Tracker.Repo.criminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class criminalService {
    @Autowired
    criminalRepo criminalRepo;

    public criminal addcriminal(criminal c) {
        return criminalRepo.save(c);
    }

    public List<criminal> allcriminal() {
        return criminalRepo.findAll();
    }

    public criminal criminalById(BigInteger id) {
        return criminalRepo.findByCriminalId(id);
    }

    public void deleteCriminal(BigInteger id) {
        criminal c = criminalRepo.findByCriminalId(id);
        if (c != null) {
            criminalRepo.delete(c);
        }
    }

    public List<criminal> findByStationId(BigInteger stationId) {
        return criminalRepo.findByStationId(stationId);
    }

    public List<criminal> searchCriminals(String name, String status) {
        List<criminal> allCriminals = criminalRepo.findAll();

        // Apply filters if provided
        if (name != null && !name.isEmpty()) {
            allCriminals = allCriminals.stream()
                    .filter(c -> c.getCriminalName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (status != null && !status.isEmpty()) {
            allCriminals = allCriminals.stream()
                    .filter(c -> c.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
        }

        return allCriminals;
    }

    public criminal addCrimeToCriminal(BigInteger criminalId, Crime crime) {
        criminal c = criminalRepo.findByCriminalId(criminalId);
        if (c == null) {
            return null;
        }

        if (c.getCrimes() == null) {
            c.setCrimes(new ArrayList<>());
        }

        c.getCrimes().add(crime);
        return criminalRepo.save(c);
    }
}