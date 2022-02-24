

package com.feefo.exercise.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;

import com.feefo.exercise.model.Job;
import com.feefo.exercise.service.JobService;




@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc 
public class JobControllerTest {


    @Autowired
    private JobService jobService;

    @Autowired
    private MockMvc mvc;


    @Before
    public void setUp() throws Exception {

      
        Job job = new Job("Software Engineer");
        assertNull(job.getId());

        job = jobService.save(job);

        assertNotNull(job.getId());
    }

    @Test
	public void testGetQuestion()
	  throws Exception {


      MockHttpServletRequestBuilder request = get("/normalise/"+"Software")                               
      .accept(MediaType.APPLICATION_JSON_UTF8);


      MockHttpServletResponse response =    mvc.perform(request)
                                  .andDo(print())
                                  .andExpect( jsonPath("title" ).isString() )
                                  .andReturn()
                                  .getResponse();


      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

	} 
    


    @After
    public void tearDown() throws Exception {

        jobService.deleteAll();
    }


}