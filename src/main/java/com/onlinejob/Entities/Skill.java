package com.onlinejob.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long skilId;

    @Column(unique = true , nullable = false)
    private String skillName;

    public Skill(long skilId, String skillName) {
        this.skilId = skilId;
        this.skillName = skillName;
    }

    public Skill() {
    }

    public long getSkilId() {
        return skilId;
    }

    public void setSkilId(long skilId) {
        this.skilId = skilId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    
}
