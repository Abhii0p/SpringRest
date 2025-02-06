package com.Abhijith.SpringBoot.Rest.Repo;


import com.Abhijith.SpringBoot.Rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public JobPost updateJob(JobPost jobPost, int id) {
       /* for (JobPost existingJob : jobs) {
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
    */

        for (JobPost job : jobs) {
            if (job.getId() == id) {
                job.setReqExperience(jobPost.getReqExperience());
            }
        }
        return jobPost;
    }


    public JobPost deleteJob(int postId) {
        if (jobs.isEmpty()) {
            System.out.println("Job list is empty.");
            return null;
        }

        JobPost deletedJob = null;
        Iterator<JobPost> iterator = jobs.iterator();

        while (iterator.hasNext()) { // Iterate safely
            JobPost jobPost = iterator.next(); // Get the next job

            if (jobPost.getId() == postId) { // Check if ID matches
                deletedJob = jobPost; // Store the job before deleting
                iterator.remove(); // Remove safely
                break; // Stop after first match
            }
        }

        // Print result
        if (deletedJob != null) {
            System.out.println("Job with ID " + postId + " has been deleted: " + deletedJob.getPostProfile());
        } else {
            System.out.println("Job with ID " + postId + " not found.");
        }

        return deletedJob; // Return deleted job or null if not found
    }


    // Method to find JobPost by id
    public JobPost findById(int id) {
        // Loop through the list of JobPost objects
        for (JobPost jobPost : jobs) {
            if (jobPost.getId() == id) {
                return jobPost;  // Return the job if found
            }
        }
        return null;  // Return null if no job with the given id is found
    }
}
