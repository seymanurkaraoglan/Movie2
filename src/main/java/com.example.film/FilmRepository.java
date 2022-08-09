package com.example.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface FilmRepository extends JpaRepository<Film,
        Long> {

    @Query("SELECT s FROM Film s WHERE s.name = ?1")
    Optional<Film> findFilmByName(String name);

    @Query("SELECT s FROM Film s WHERE s.genre = ?1")
    Optional<Film> findFilmByGenre(String genre);

    @Override
    @Query("SELECT s FROM Film s WHERE s.id=?1")
    boolean existsById(Long id);

    @Query("SELECT s FROM Film s WHERE s.name=?1")
    boolean existByName(String name);

    @Query("SELECT s FROM Film s WHERE s.genre=?1")
    boolean existByGenre(String genre);
}
