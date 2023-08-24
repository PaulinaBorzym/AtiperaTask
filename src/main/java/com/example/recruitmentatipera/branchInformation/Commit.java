package com.example.recruitmentatipera.branchInformation;

public class Commit {
    private String sha;

    public Commit(String sha) {
        this.sha = sha;
    }

    public Commit() {
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
