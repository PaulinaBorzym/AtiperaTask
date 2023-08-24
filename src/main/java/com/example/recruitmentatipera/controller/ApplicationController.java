package com.example.recruitmentatipera.controller;

import com.example.recruitmentatipera.error.ErrorMessage;
import com.example.recruitmentatipera.githubRepository.GithubRepository;
import com.example.recruitmentatipera.githubRepository.GithubRepositoryDTO;
import com.example.recruitmentatipera.githubRepository.GithubRepositoryMapper;
import com.example.recruitmentatipera.branchInformation.Branch;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApplicationController {

        private final String GITHUB_API_URL = "https://api.github.com/users/";
        private RestTemplate restTemplate = new RestTemplate();
        private final GithubRepositoryMapper mapper;

    public ApplicationController(GithubRepositoryMapper mapper) {
        this.mapper = mapper;
    }


    @GetMapping(value = "/repositories/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object> getRepositories(
                @PathVariable String username){
            String githubApiUrl = GITHUB_API_URL + username + "/repos";
        GithubRepository[] repositories;

            try {
                repositories = restTemplate.getForObject(githubApiUrl, GithubRepository[].class);
            }catch (HttpClientErrorException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ErrorMessage(404,"User " + username +" not found."));

            }

                List<GithubRepositoryDTO> githubDTOList = Arrays.stream(repositories)
                        .filter(r -> !r.getFork())
                        .map(r -> getBranchesInfo(r))
                        .map(r -> mapper.mapToGithubRepositoryDTO(r))
                        .collect(Collectors.toList());


                return ResponseEntity.ok(githubDTOList);
      }

    private GithubRepository getBranchesInfo(GithubRepository repository) {
            String branchesURL = repository.getBranches_url().substring(0,repository.getBranches_url().length()-9);
            Branch[] branches = restTemplate.getForObject(branchesURL, Branch[].class);
            repository.setBranches(Arrays.stream(branches).toList());
            return repository;
    }

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Object> handleHttpMediaTypeNotAcceptableException(){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                new ErrorMessage(406,"Unsupported Media Type."));
    }

}
