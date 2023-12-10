package com.JobListingProject.JobListing.Model;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "JobPost")
public class Post {

    private String  profile;
    private String desc;
    private Integer exp;
   private String []techs;
}
