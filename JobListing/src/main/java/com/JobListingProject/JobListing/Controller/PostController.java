package com.JobListingProject.JobListing.Controller;



import com.JobListingProject.JobListing.Model.Post;
import com.JobListingProject.JobListing.Service.PostServiceInterface;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

@Autowired
    PostServiceInterface postServiceInterface;
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("allPost")
    public ResponseEntity<List<Post>> allPost(){
        return  postServiceInterface.allPost();
    }
    @PostMapping("addPost")
    public ResponseEntity<String> addPost(@RequestBody Post post){
        return postServiceInterface.addPost(post);
    }

    @GetMapping("posts/{text}")
    public ResponseEntity<List<Post>> search(@PathVariable String text){
        return postServiceInterface.search(text);
    }

}
