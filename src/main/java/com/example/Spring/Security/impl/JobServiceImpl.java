package com.example.Spring.Security.impl;
import com.example.Spring.Security.Entity.Job;
import com.example.Spring.Security.Repository.JobRepository;
import com.example.Spring.Security.Services.JobServices;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class JobServiceImpl implements JobServices {
//    private List<Job> jobs = new ArrayList<>();

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    JobRepository jobRepository;
    private Long nextID = 1L;


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }


    @Override
    public void createJob(Job job) {
        job.setId(nextID++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
      try {
          jobRepository.deleteById(id);
          return true;

      }
      catch (Exception e){
          return false;
      }


    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setDescription(updatedJob.getDescription());
            job.setTitle(updatedJob.getTitle());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            jobRepository.save(job);

            return true;
        }
        return false;
    }

}
