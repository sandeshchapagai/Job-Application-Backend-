package com.example.Spring.Security.Controller;

import com.example.Spring.Security.Entity.Job;
import com.example.Spring.Security.Services.JobServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobServices jobServices;
   @GetMapping("/jobs")
    public List<Job> findAll(){
       return jobServices.findAll();
   }

   @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
      jobServices.createJob(job);
      return "job added successfully";
   }
}
