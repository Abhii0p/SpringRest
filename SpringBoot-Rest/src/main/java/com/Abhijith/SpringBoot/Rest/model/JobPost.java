package com.Abhijith.SpringBoot.Rest.model;

import java.util.List;

public class JobPost {
    private int id;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

    // Default constructor
    public JobPost() {}

    // Parameterized constructor
    public JobPost(int id, String postProfile, String postDesc, int reqExperience, List<String> postTechStack) {
        this.id = id;
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExperience = reqExperience;
        this.postTechStack = postTechStack;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public int getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience) {
        this.reqExperience = reqExperience;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id +
                ", postProfile='" + postProfile + '\'' +
                ", postDesc='" + postDesc + '\'' +
                ", reqExperience=" + reqExperience +
                ", postTechStack=" + postTechStack +
                '}';
    }
}
