package org.example.vraag1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Director {
    @Id
    private String name;
    @ManyToMany(mappedBy = "directors", fetch = FetchType.EAGER)
    private List<Movie> movies;

    public Director() {
    }

    public Director(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
