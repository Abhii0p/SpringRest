package com.Abhijith.SpringBoot.Rest;

import com.Abhijith.SpringBoot.Rest.model.JobPost;
import com.Abhijith.SpringBoot.Rest.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/jobPostt/{id}")
    public JobPost updateJob(@PathVariable("id") int id,@RequestBody JobPost jobPost) {

        System.out.println("Function called with "+id);
        return service.updateJob(jobPost,id);

    }




    @DeleteMapping("/jobPost/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        try {
            JobPost deletedJob = service.deleteJob(id);

            if (deletedJob != null) {
                // Return a custom success message
                return ResponseEntity.ok("Job post with ID " + id + " has been successfully deleted.");
            } else {
                // Return a custom "not found" message with a 404 status
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Job post with ID " + id + " does not exist.");
            }
        } catch (Exception e) {
            // Return a custom error message in case of an unexpected issue
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong while deleting the job post. Please try again later.");
        }
    }

}
