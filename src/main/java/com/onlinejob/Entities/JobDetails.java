package com.onlinejob.Entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.*;

import com.onlinejob.Entities.Enums.JobType;

@Entity
public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable =  false)
    private String companyName;

    
    @Column(nullable =  false)
    private String jobRole;

    @Column(nullable =  false , columnDefinition = "TEXT")
    private String jobDescription;

    @Column(nullable =  false)
    private long salary;

    @ManyToMany()
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany(mappedBy = "appliedJobs")
    private List<JobSeeker> appliedSeekers;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(nullable = false)
    private LocalDate lastDateToApply;

    private LocalDate postedDate = LocalDate.now();
    
    @Enumerated(EnumType.STRING)
    private JobType jobType;    
    
    private String location;

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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
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
}
