package com.example.Spring.Security.Controller;

import com.example.Spring.Security.Entity.Job;
import com.example.Spring.Security.Services.JobServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobServices jobServices;

    public JobController(JobServices jobServices) {
        this.jobServices = jobServices;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobServices.findAll();
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobServices.createJob(job);
        return new ResponseEntity<>("Job Added Successfully!!",HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobServices.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String> deleteJob(Long id){
        boolean deletedJobById = jobServices.deleteJobById(id);
        if(deletedJobById)
            return  new ResponseEntity<>("Job deleted Sucessfully",HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
