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
        It sends the job of an question by refering 
        the questionId, optionId and the jobedText (if thats the case)

        Returns the Test Entity, also with information of remaining time
        and next question to be jobed.
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
