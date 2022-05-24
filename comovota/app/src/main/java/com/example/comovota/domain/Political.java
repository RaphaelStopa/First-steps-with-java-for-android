package com.example.comovota.domain;

import com.example.comovota.Data;
import com.example.comovota.domain.enumeration.ElectivePositionType;
import com.example.comovota.domain.enumeration.TypeOfVote;

import java.util.HashSet;
import java.util.Set;

public class Political {

    private Long id;

    private String name;

    // I did it by enum because at first, only these two make sense. However, in the future, if applicable, there may be other
    private ElectivePositionType electivePositionType;

    private PoliticalParty politicalParty;

    private Set<Vote> votes = new HashSet<>();

    //soft delete
    private boolean deleted = false;

    public Political(Long id, String name, ElectivePositionType electivePositionType, PoliticalParty politicalParty, Set<Vote> votes, boolean deleted) {
        this.id = id;
        this.name = name;
        this.electivePositionType = electivePositionType;
        this.politicalParty = politicalParty;
        this.votes = votes;
        this.deleted = deleted;
    }

    public Political() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ElectivePositionType getElectivePositionType() {
        return electivePositionType;
    }

    public void setElectivePositionType(ElectivePositionType electivePositionType) {
        this.electivePositionType = electivePositionType;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    @Override
    public String toString() {
        return  '\n' + name + '\n' + '\n' + "Partido= " + politicalParty;
    }
}
