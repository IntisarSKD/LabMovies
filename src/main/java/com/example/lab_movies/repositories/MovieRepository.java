package com.example.lab_movies.repositories;

import com.example.lab_movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
