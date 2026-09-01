package com.oraclejava.springmvc;

import com.oraclejava.springmvc.models.Genre;
import com.oraclejava.springmvc.models.Movie;
import com.oraclejava.springmvc.repositories.GenreRepository;
import com.oraclejava.springmvc.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;
    private Long id;

    @RequestMapping(value = "/editMovie/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, @ModelAttribute("editMovieForm")Movie movie, Model model){
        Movie foundMovie = movieRepository.findById(id).orElseThrow();
        System.out.println("----------------------------------");
        System.out.println(foundMovie);
        List<Genre> genreList = genreRepository.findAll();
        model.addAttribute("genreList", genreList);
        movie.setId(foundMovie.getId());
        movie.setName(foundMovie.getName());
        movie.setPrice(foundMovie.getPrice());
        movie.setReleaseYear(foundMovie.getReleaseYear());
        movie.setGenreId(foundMovie.getGenre().getId());
        System.out.println(movie);
        return "edit_movie";
    }

    @Transactional
    @RequestMapping(value = "/editMovie", method = RequestMethod.POST)
    public String editMovie(@ModelAttribute("editMovieForm")Movie movie){
        Genre genre = genreRepository.findById(movie.getGenreId()).orElseThrow();
        movie.setGenre(genre);
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @RequestMapping(value = "/createMovie", method = RequestMethod.GET)
    public String create(@ModelAttribute("createMovieForm")Movie movie,
                         Model model) {
        List<Genre> genreList = genreRepository.findAll();
        model.addAttribute("genreList", genreList);
        return "create_movie";  //create_movie.html
    }

    @Transactional
    @RequestMapping(value = "/createMovie", method = RequestMethod.POST)
    public String createMovie(@ModelAttribute("createMovieForm") @Validated Movie movie
            , BindingResult result, Model model) {
        if (!result.hasErrors()){
            Genre genre = genreRepository.findById(movie.getGenreId()).orElseThrow();
            movie.setGenre(genre);
            movieRepository.save(movie);
            return "redirect:/movies";
        } else {
            List<Genre> genreList = genreRepository.findAll();
            model.addAttribute("genreList", genreList);
            return "create_movie";
        }
    }

    @Transactional
    @RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.GET)
    public  String delete(@PathVariable("deleteMovieForm")Movie movie){

        movieRepository.deleteById(id);
        return "redirect:/movies";
    }
}
