package com.movie.catelog.demo.controller;

import com.movie.catelog.demo.pojo.CatelogItem;
import com.movie.catelog.demo.pojo.Movie;
import com.movie.catelog.demo.pojo.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogController {


    @Autowired
    WebClient.Builder webClientBuilder ;
    @Autowired
    RestTemplate restTemplate ;
    @RequestMapping ("/{userId}")
    public List<CatelogItem> getMovies(@PathVariable String userId){

        //get all the ratings of the movies
        List<Rating> ratings = Arrays.asList(new Rating("12234",3),
                new Rating("12345",5));
        //then for each movie id call the movieinfo service to get movie details
       return ratings.stream().map(rating -> {
           //old way
          //Movie movie =  restTemplate.getForObject("http://localhost:8083/movies/"+rating.getMovieId(), Movie.class);

           //new way
           Movie movie = webClientBuilder.build()
                   .get()
                   .uri("http://movie-info-service/movies/"+rating.getMovieId())
                   .retrieve()
                   .bodyToMono(Movie.class)
                   .block();
          return new CatelogItem(movie.getMovieId(), movie.getDesc(), 4);
        }).collect(Collectors.toList());

        //Put them all together

        //return Collections.singletonList(new CatelogItem("Laagan","Cricket Movie",5));
    }

    @RequestMapping ("/foo")
    public List<CatelogItem> getMovies(){
        return Collections.singletonList(new CatelogItem("Badsha","Cricket Movie",5));
    }

}
