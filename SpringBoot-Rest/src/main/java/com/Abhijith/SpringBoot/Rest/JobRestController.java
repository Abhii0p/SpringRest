package com.Abhijith.SpringBoot.Rest;

import com.Abhijith.SpringBoot.Rest.model.JobPost;
import com.Abhijith.SpringBoot.Rest.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    private final JobService service;

    public JobRestController(JobService service) {
        this.service = service;
    }

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }
    @GetMapping("/jobPost/{id}")
    public JobPost getJob(@PathVariable int id) {
        return service.getJob(id);

    }
    @PostMapping("jobPost")
    public  void addjob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);

    }
    @PutMapping("/jobPost/{id}")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        return service.updateJob(jobPost);
    }
    @DeleteMapping("/jobPost/{id}")
    public String deleteJob(@PathVariable int id){
        service.deleteJob(id);
        return "Deleted";
    }
}
