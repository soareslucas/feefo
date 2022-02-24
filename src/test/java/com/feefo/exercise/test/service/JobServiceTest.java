package com.feefo.exercise.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.List;

import com.feefo.exercise.model.Job;
import com.feefo.exercise.service.JobService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobServiceTest {


    @Autowired
    private JobService jobService;

    @Before
    public void setUp() throws Exception {

        jobService.deleteAll();

		Job job1 = new Job("Architect");
        Job job2 = new Job("Software engineer");
        Job job3 = new Job("Quantity surveyor");
        Job job4 = new Job("Accountant");


        assertNull(job1.getId());
        assertNull(job2.getId());
        assertNull(job3.getId());
        assertNull(job4.getId());

        job1 = jobService.save(job1);
        job2 = jobService.save(job2);
        job3 = jobService.save(job3);
        job4 = jobService.save(job4);
        
        assertNotNull(job1.getId());
        assertNotNull(job2.getId());
        assertNotNull(job3.getId());
        assertNotNull(job4.getId());

    }

    @Test
    public void testFetchData(){

        List<Job> jobs = jobService.findAll();
        assertEquals(jobs.size(), 4);
    }


    @Test
    public void testNormalise(){

        Job job = jobService.getJobNormalised("Software Developer");
        
        assertNotNull(job);
        assertEquals("Software engineer", job.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        jobService.deleteAll();
    }
}