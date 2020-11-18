package com.example.movieinfoapi.controller;


import com.example.movieinfoapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")

public class MovieController {

    @RequestMapping("/{movieId}")
    public Movie getinfomovie(@PathVariable String movieId){

        return new Movie(movieId, "test");

    }

}
