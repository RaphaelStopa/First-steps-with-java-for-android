package com.example.comovota.domain;

import com.example.comovota.domain.enumeration.TypeOfVote;

public class Vote {

    private TypeOfVote typeOfVote;

    private Project project;

    public Vote(TypeOfVote typeOfVote, Project project) {
        this.typeOfVote = typeOfVote;
        this.project = project;
    }

    public Vote() {
    }

    public TypeOfVote getTypeOfVote() {
        return typeOfVote;
    }

    public void setTypeOfVote(TypeOfVote typeOfVote) {
        this.typeOfVote = typeOfVote;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
