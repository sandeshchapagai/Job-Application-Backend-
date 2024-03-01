package com.example.Spring.Security.impl;

import com.example.Spring.Security.Entity.Job;
import com.example.Spring.Security.Services.JobServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobServices {
    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll(){
        return jobs;
    }

    @Override
    public void createJob() {

    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

}
