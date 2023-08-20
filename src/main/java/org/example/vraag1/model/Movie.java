package org.example.vraag1.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    @Column
    private String title;

    @Column
    private String country;

    @Column
    private String releaseYear;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private Set<Director> directors;
    public Movie(){}
    public Movie(int showId, String title, String country, String releaseYear, String description) {
        this.showId = showId;
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
        this.description = description;
        this.directors = new HashSet<>();
    }
}
