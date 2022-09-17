package com.movie.catelog.demo.controller;

import com.movie.catelog.demo.pojo.CatelogItem;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogController {


    @RequestMapping ("/{userId}")
    public List<CatelogItem> getMovies(@PathVariable String userId){
        return Collections.singletonList(new CatelogItem("Laagan","Cricket Movie",5));
    }

    @RequestMapping ("/foo")
    public List<CatelogItem> getMovies(){
        return Collections.singletonList(new CatelogItem("Badsha","Cricket Movie",5));
    }

}
