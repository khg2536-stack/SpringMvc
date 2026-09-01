package com.oraclejava.springmvc.repositories;

import com.oraclejava.springmvc.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("""
        select m
            from Movie m 
                join fetch m.genre
            """)
    List<Movie> findMoviesForGenre();

}
