package com.onlinejob.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.onlinejob.Entities.Enums.JobType;

@Entity
public class JobDetails {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //compnayName
    @Column(nullable =  false)
    private String companyName;

    @Override
    public String toString() {
        return "JobDetails [id=" + id + ", companyName=" + companyName + ", jobRole=" + jobRole + ", jobDescription="
                + jobDescription + ", salary=" + salary + ", appliedSeekers=" + appliedSeekers + ", employer="
                + employer + ", lastDateToApply=" + lastDateToApply + ", postedDate=" + postedDate + ", jobType="
                + jobType + ", location=" + location + ", skills=" + skills + "]";
    }

    //jobrole
    @Column(nullable =  false)
    private String jobRole;
    //jobDescription
    @Column(nullable =  false , columnDefinition = "TEXT")
    private String jobDescription;
    //salary
    @Column(nullable =  false)
    private long salary;
    //appliedSeekers
    @ManyToMany(mappedBy = "appliedJobs")
    private List<JobSeeker> appliedSeekers;
    //employer
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    //lastdate
    @Column(nullable = false)
    private LocalDate lastDateToApply;
    //postedDate
    private LocalDate postedDate = LocalDate.now();
    //jobType
    @Enumerated(EnumType.STRING)
    private JobType jobType;    
    //location
    private String location;
    //skills req
    @ElementCollection
    private List<String> skills = new ArrayList<>();
    
    /**
     * 
     * GETTERS AND SETTERS
     *      
     * */
    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
    
    public Employer getEmployer() {
        return employer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
  
    public List<JobSeeker> getAppliedSeekers() {
        return appliedSeekers;
    }

    public void setAppliedSeekers(List<JobSeeker> appliedSeekers) {
        this.appliedSeekers = appliedSeekers;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getJobRole() {
        return jobRole;
    }
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    public LocalDate getLastDateToApply() {
        return lastDateToApply;
    }
    public void setLastDateToApply(LocalDate lastDateToApply) {
        this.lastDateToApply = lastDateToApply;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
