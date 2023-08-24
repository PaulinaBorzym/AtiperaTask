package com.example.recruitmentatipera.githubRepository;

import com.example.recruitmentatipera.branchInformation.BranchDTO;

import java.util.List;

public class GithubRepositoryDTO {
    private String name;
    private String ownerLogin;
    private List<BranchDTO> branches;

    public GithubRepositoryDTO(String name, String ownerLogin, List<BranchDTO> branches) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public GithubRepositoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public List<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDTO> branches) {
        this.branches = branches;
    }
}
