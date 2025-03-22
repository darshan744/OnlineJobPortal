package com.onlinejob.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("EMPLOYER")
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

    @Override
    public String toString() {
        return "Employer [companyName=" + companyName +"]";
    }


}
