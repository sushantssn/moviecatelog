package com.movie.catelog.demo.controller;

import com.movie.catelog.demo.pojo.CatelogItem;
import com.movie.catelog.demo.pojo.Rating;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogController {


    @RequestMapping ("/{userId}")
    public List<CatelogItem> getMovies(@PathVariable String userId){

        //get the ratings of the movies
        List<Rating> ratings = Arrays.asList(new Rating("12234",3),
                new Rating("12345",5));
        return Collections.singletonList(new CatelogItem("Laagan","Cricket Movie",5));
    }

    @RequestMapping ("/foo")
    public List<CatelogItem> getMovies(){
        return Collections.singletonList(new CatelogItem("Badsha","Cricket Movie",5));
    }

}
