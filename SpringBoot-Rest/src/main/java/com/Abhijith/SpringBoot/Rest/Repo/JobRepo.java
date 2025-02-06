package com.Abhijith.SpringBoot.Rest.Repo;


import com.Abhijith.SpringBoot.Rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class JobRepo {

    // List to store JobPost objects
    private final List<JobPost> jobs = new ArrayList<>();

    // Constructor: Populates the list with sample JobPost objects
    public JobRepo() {
        // Java Developer Job Post
        jobs.add(new JobPost(1, "Java Developer",
                "Experience in building scalable web applications using Java", 3,
                Arrays.asList("Java", "Spring", "Hibernate", "REST APIs")));

        // Frontend Developer Job Post
        jobs.add(new JobPost(2, "Frontend Developer",
                "Experience in building responsive web applications using React", 3,
                Arrays.asList("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobs.add(new JobPost(3, "Data Scientist",
                "Strong background in machine learning and data analysis", 4,
                Arrays.asList("Python", "Machine Learning", "Data Analysis")));

        // Network Engineer Job Post
        jobs.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                Arrays.asList("Networking", "Cisco", "Routing", "Switching")));

        // Mobile App Developer Job Post
        jobs.add(new JobPost(5, "Mobile App Developer",
                "Experience in mobile app development for iOS and Android", 3,
                Arrays.asList("iOS Development", "Android Development", "Mobile App")));

        // DevOps Engineer Job Post
        jobs.add(new JobPost(6, "DevOps Engineer",
                "Implement and manage continuous integration and delivery pipelines", 4,
                Arrays.asList("DevOps", "CI/CD", "Docker", "Kubernetes")));

        // UI/UX Designer Job Post
        jobs.add(new JobPost(7, "UI/UX Designer",
                "Create engaging user experiences and intuitive user interfaces", 2,
                Arrays.asList("User Experience", "User Interface Design", "Prototyping")));

        // Cybersecurity Analyst Job Post
        jobs.add(new JobPost(8, "Cybersecurity Analyst",
                "Protect computer systems and networks from cyber threats", 4,
                Arrays.asList("Cybersecurity", "Network Security", "Incident Response")));

        // Full Stack Developer Job Post
        jobs.add(new JobPost(9, "Full Stack Developer",
                "Experience in both front-end and back-end development", 5,
                Arrays.asList("JavaScript", "Node.js", "React", "Spring", "MongoDB")));

        // Cloud Architect Job Post
        jobs.add(new JobPost(10, "Cloud Architect",
                "Design and implement cloud infrastructure solutions", 6,
                Arrays.asList("Cloud Computing", "AWS", "Azure", "Google Cloud")));

        // Software Tester Job Post
        jobs.add(new JobPost(11, "Software Tester",
                "Ensure software quality through testing and validation", 3,
                Arrays.asList("Testing", "JUnit", "Selenium", "TestNG")));

        // React Native Developer Job Post
        jobs.add(new JobPost(12, "React Native Developer",
                "Develop cross-platform mobile applications using React Native", 2,
                Arrays.asList("React Native", "JavaScript", "Mobile App Development")));

        // Business Analyst Job Post
        jobs.add(new JobPost(13, "Business Analyst",
                "Analyze business processes and recommend improvements", 4,
                Arrays.asList("Business Analysis", "Requirements Gathering", "Process Modeling")));

        // Embedded Systems Engineer Job Post
        jobs.add(new JobPost(14, "Embedded Systems Engineer",
                "Design and develop embedded systems for hardware applications", 5,
                Arrays.asList("Embedded Systems", "C/C++", "Microcontrollers", "RTOS")));
    }

    // Retrieves an unmodifiable list of all job posts
    public List<JobPost> getAllJobs() {
        return Collections.unmodifiableList(jobs);
    }

    // Adds a new job post after validating that it's not null
    public void addJob(JobPost job) {
        if (job == null) {
            throw new IllegalArgumentException("JobPost cannot be null");
        }
        jobs.add(job);
    }



    public JobPost getJob(int postId) {
        for (JobPost job : jobs) {
            if (job.getId() == postId) {
                return job;
            }
        }
        return null;
    }

    public JobPost updateJob(JobPost jobPost) {
        for (JobPost existingJob : jobs) {
            if (existingJob.getId() == jobPost.getId()) {
                // ✅ Update properties
                existingJob.setPostProfile(jobPost.getPostProfile());
                existingJob.setPostDesc(jobPost.getPostDesc());
                existingJob.setReqExperience(jobPost.getReqExperience());
                existingJob.setPostTechStack(jobPost.getPostTechStack());
                return existingJob;
            }
        }
        return null; // Or throw an exception if the job is not found
    }

    public void deleteJob(int postId){
        for(JobPost jobPost:jobs){
            if(jobPost.getId()==postId)
            {
                jobs.remove(jobPost);

            }
        }
    }


}
