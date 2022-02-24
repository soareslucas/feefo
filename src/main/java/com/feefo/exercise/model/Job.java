package com.feefo.exercise.model;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Entity;

@Data
@Entity
public class Job {

    private @Id @GeneratedValue Long id;
	private String title;


    public Job() {
    }

    public Job(String title) {
        this.title = title;
    }

    
}



