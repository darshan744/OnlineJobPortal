package com.onlinejob.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name="user_id")
public class Employer extends User {

    private String companyName;

    @OneToMany(mappedBy = "employer")
    private Set<JobDetails> postedJobs;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<JobDetails> getPostedJobs() {
        return postedJobs;
    }

    public void setPostedJobs(Set<JobDetails> postedJobs) {
        this.postedJobs = postedJobs;
    }
}
