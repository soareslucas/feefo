package com.feefo.exercise.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feefo.exercise.model.Job;
import com.feefo.exercise.repository.JobRepository;
import com.feefo.exercise.utils.Normaliser;


@Service
public class JobService {


    @Autowired
    private JobRepository jobRepository;

    private final Normaliser normaliser = new Normaliser();

    public Job getJobNormalised(String search) {

        List<String> listJobTitles = new ArrayList<>();
        List<Job> jobs = jobRepository.findAll();


        for(Job job : jobs){
            listJobTitles.add(job.getTitle());
        }

        String normalisedTitle = normaliser.normalise(search, listJobTitles);


        Optional<Job> matchingObject = jobs.stream().
        filter(p -> p.getTitle().equals(normalisedTitle)).
        findFirst();

        Job job = matchingObject.get();

        return job;

    }


    public Job save(Job job) {
         return jobRepository.save(job);
    }


    public void deleteAll(){
        jobRepository.deleteAll();
    }    
    
    public List<Job> findAll() {
        return jobRepository.findAll();
   }

}