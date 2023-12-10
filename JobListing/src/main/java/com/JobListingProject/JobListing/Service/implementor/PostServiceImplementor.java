package com.JobListingProject.JobListing.Service.implementor;

import com.JobListingProject.JobListing.Model.Post;
import com.JobListingProject.JobListing.Repository.PostRepo;
import com.JobListingProject.JobListing.Service.PostServiceInterface;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class PostServiceImplementor implements PostServiceInterface {
    @Autowired
    PostRepo postRepo;
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    public ResponseEntity<List<Post>> allPost(){
        return new ResponseEntity<>(postRepo.findAll(), HttpStatusCode.valueOf(200));
    }
    public ResponseEntity<String> addPost(Post post){
       postRepo.save(post);
        return new ResponseEntity<>("Success",HttpStatusCode.valueOf(201));
    }
    public ResponseEntity<List<Post>> search(String text){

        List<Post>posts=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("Ravi");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text", new Document("query", text).append("path", Arrays.asList("desc", "profile", "techs")))),
                      new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(document -> posts.add(mongoConverter.read(Post.class,document)));
        return new ResponseEntity<>(posts,HttpStatusCode.valueOf(200));
    }
}
