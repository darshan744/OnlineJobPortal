package com.onlinejob.Entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long skillId;

    @Column(unique = true , nullable = false)
    private String skillName;

    @ManyToMany(mappedBy = "skills")
    private Set<JobDetails> jobDetailsList;

    public Skill(long skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public Skill() {
    }

    public Set<JobDetails> getJobDetailsList() {
        return jobDetailsList;
    }

    public void setJobDetailsList(Set<JobDetails> jobDetailsList) {
        this.jobDetailsList = jobDetailsList;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
