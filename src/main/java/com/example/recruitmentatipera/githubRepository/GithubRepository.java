package com.example.recruitmentatipera.githubRepository;

import com.example.recruitmentatipera.branchInformation.Branch;
import com.example.recruitmentatipera.branchInformation.Owner;
import java.util.List;

public class GithubRepository {
    private String name;
    private Owner owner;
    private Boolean fork;
    private String branches_url;

    private List<Branch> branches;

    public GithubRepository(String name, Owner owner, Boolean fork, String branches_url, List<Branch> branches) {
        this.name = name;
        this.owner = owner;
        this.fork = fork;
        this.branches_url = branches_url;
        this.branches = branches;
    }

    public GithubRepository() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
