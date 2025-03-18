package com.onlinejob.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("JOBSEEKER")
public class JobSeeker extends User {

    private String devRole;

    private String linkedInLink;

    private String githubLink;

    private  String leetCodeLink;

    @ManyToMany
    @JoinTable(
            name = "applied_jobs",
            joinColumns = @JoinColumn(name = "jobseeker_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private Set<JobDetails> appliedJobs;

    public String getDevRole() {
        return devRole;
    }

    public JobSeeker() {
    }

    public void setDevRole(String devRole) {
        this.devRole = devRole;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLeetCodeLink() {
        return leetCodeLink;
    }

    public void setLeetCodeLink(String leetCodeLink) {
        this.leetCodeLink = leetCodeLink;
    }

    public Set<JobDetails> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(Set<JobDetails> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}
