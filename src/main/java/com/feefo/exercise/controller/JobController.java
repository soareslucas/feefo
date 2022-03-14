package com.feefo.exercise.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.feefo.exercise.service.JobService;
import com.feefo.exercise.model.Job;

@RestController
public class JobController {
	
    @Autowired
    private JobService jobService;

    /* 
        Pass the string to be normlised through the param {jobTitle}
        in the url.

        If you want to test the string "C# Engineer" please replace
        the char # for %23.

        Returns the Job Title Normalised
    */

    @RequestMapping(value="/normalise/{jobTitle}", method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Job> setJob(@PathVariable String jobTitle) throws Exception {    

        Job job =  jobService.getJobNormalised(jobTitle);    

        return ResponseEntity
                .ok()   
                .contentType(MediaType.APPLICATION_JSON)
                .body(job);
    }



}
