package com.Abhijith.SpringBoot.Rest.service;


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
   public JobPost updateJob(JobPost jobPost) {
       return repo.updateJob(jobPost);
   }

    public void deleteJob(int id) {
        repo.deleteJob(id);
    }


}