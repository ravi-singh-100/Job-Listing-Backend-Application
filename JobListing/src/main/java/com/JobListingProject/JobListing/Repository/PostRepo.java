package com.JobListingProject.JobListing.Repository;

import com.JobListingProject.JobListing.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepo extends MongoRepository<Post,String> {

}
