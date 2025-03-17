package com.onlinejob.Entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
    private String salary;

    @Column(nullable =  false)
    @ManyToMany()
    private Set<Skill> skills = new HashSet<>();

    @Column(nullable = false)
    private LocalDate lastDateToApply;
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
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public LocalDate getLastDateToApply() {
        return lastDateToApply;
    }
    public void setLastDateToApply(LocalDate lastDateToApply) {
        this.lastDateToApply = lastDateToApply;
    }
}
