package com.Abhijith.SpringBoot.Rest.service;


import com.Abhijith.SpringBoot.Rest.JobNotFoundException;
import com.Abhijith.SpringBoot.Rest.Repo.JobRepo;
import com.Abhijith.SpringBoot.Rest.model.JobPost;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {

    private final JobRepo repo;

    public JobService(JobRepo repo) {
        this.repo = repo;
    }

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(int id) {
        return repo.getJob(id);
    }
   public JobPost updateJob(JobPost jobPost,int id) {
       return repo.updateJob(jobPost,id);
   }

    public JobPost deleteJob(int id) {
        // Fetch job details by id
        JobPost jobPost = repo.findById(id);

        // If job not found, throw a custom exception
        if (jobPost == null) {
             throw new JobNotFoundException("Service issue: Something went wrong. Job with ID " + id + " not found.");

        }

        // Perform the actual deletion from the repository
        repo.deleteJob(id);

        // Return the deleted job
        return jobPost;
    }



}