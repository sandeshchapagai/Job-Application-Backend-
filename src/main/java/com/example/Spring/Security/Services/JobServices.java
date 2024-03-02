package com.example.Spring.Security.Services;

import com.example.Spring.Security.Entity.Job;

import java.util.List;

public interface JobServices {


    List<Job> findAll();

    void createJob();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);
}
