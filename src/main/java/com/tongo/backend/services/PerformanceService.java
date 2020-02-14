package com.tongo.backend.services;

import com.tongo.backend.data.models.Performance;
import com.tongo.backend.repositories.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceService {
    @Autowired
    PerformanceRepository performanceRepository;

    public List<Performance> getFuturePerformance(){
        Date date = new Date(System.currentTimeMillis());
        List<Performance> allPerf = (List<Performance>) performanceRepository.findAll();
        return allPerf.stream().filter(performances -> performances.getDatetime().after(date)).collect(Collectors.toList());
    }
    public List<Performance> getFuturePerformanceByPlay(int id){
        Date date = new Date(System.currentTimeMillis());
        List<Performance> allPerf = (List<Performance>) performanceRepository.findByPlay(id);
        return allPerf.stream().filter(performances -> performances.getDatetime().after(date)).collect(Collectors.toList());
    }

    public List<Performance> getPerformances(){

        List<Performance> allPerf = (List<Performance>) performanceRepository.findAll();
        return allPerf;
    }


}
