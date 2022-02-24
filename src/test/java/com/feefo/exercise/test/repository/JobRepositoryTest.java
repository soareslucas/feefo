package com.feefo.exercise.test.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import com.feefo.exercise.model.Job;
import com.feefo.exercise.repository.JobRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobRepositoryTest {


    @Autowired
    private JobRepository jobRepository;

    @Before
    public void setUp() throws Exception {

        this.jobRepository.deleteAll();

		Job job1 = new Job("Architect");
        Job job2 = new Job("Software engineer");

        assertNull(job1.getId());
        assertNull(job2.getId());

        job1 = jobRepository.save(job1);
        job2 = jobRepository.save(job2);
        
        assertNotNull(job1.getId());
        assertNotNull(job2.getId());

    }

    @Test
    public void testFetchData(){

        List<Job> jobs = jobRepository.findAll();

        assertEquals(jobs.size(), 2);
    }


    @Test
    public void testDataUpdate(){

        List<Job> jobs = jobRepository.findAll();
        Long idJob = jobs.stream().findFirst().get().getId();   

        Optional<Job> jobOp = jobRepository.findById(idJob);        
        Job job = jobOp.get();


        job.setTitle("Accountant");
        jobRepository.save(job);

        Optional<Job> jobOp2 = jobRepository.findById(idJob);
        Job job2 = jobOp2.get();

        assertNotNull(job2);
        assertEquals("Accountant", job2.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        this.jobRepository.deleteAll();
    }
}