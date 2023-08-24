package com.example.recruitmentatipera.githubRepository;

import com.example.recruitmentatipera.branchInformation.Branch;
import com.example.recruitmentatipera.branchInformation.BranchDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubRepositoryMapper {
    public GithubRepositoryDTO mapToGithubRepositoryDTO(final GithubRepository githubRepository) {
        return new GithubRepositoryDTO(
                githubRepository.getName(),
                githubRepository.getOwner().getLogin(),
                mapToBranchDTOList(githubRepository.getBranches())
        );
    }

    private BranchDTO mapToBranchDTO(final Branch branch) {
        return new BranchDTO(
                branch.getName(),
                branch.getCommit().getSha()
        );
    }

    private List<BranchDTO> mapToBranchDTOList(final List<Branch> branches) {
        return branches.stream()
                .map(this::mapToBranchDTO)
                .collect(Collectors.toList());
    }
}
