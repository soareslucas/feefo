package com.feefo.exercise.repository;

import com.feefo.exercise.model.Job;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * @author Lucas Soares
 */

@RepositoryRestResource(collectionResourceRel = "jobs", path = "jobs", exported = true)
public interface JobRepository extends  JpaSpecificationExecutor<Job>, PagingAndSortingRepository<Job, Long> {

    @Override
    List<Job> findAll();

    @Override
    Optional<Job> findById(Long id);
}