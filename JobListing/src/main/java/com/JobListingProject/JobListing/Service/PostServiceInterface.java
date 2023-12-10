package com.JobListingProject.JobListing.Service;

import com.JobListingProject.JobListing.Model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostServiceInterface {

    ResponseEntity<List<Post>> allPost();

    ResponseEntity<String> addPost(Post post);

    ResponseEntity<List<Post>> search(String text);
}
