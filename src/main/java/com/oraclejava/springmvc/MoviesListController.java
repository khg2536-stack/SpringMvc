package com.oraclejava.springmvc;

import com.oraclejava.springmvc.models.Movie;
import com.oraclejava.springmvc.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MoviesListController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/movies")
    public String list(Model model){

        List<Movie> movieList = movieRepository.findAll();

        model.addAttribute("movieList", movieList);
        return "movie_list";
    }

}
