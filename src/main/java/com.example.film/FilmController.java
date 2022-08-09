package com.example.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/film")
@RestController
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;

    }
    @GetMapping
    public List<Film> getFilms(){
        return filmService.getFilms();
    }
    @PostMapping
    public void registerNewFilm(@RequestBody Film film){
        filmService.addNewFilm(film);
    }
    @DeleteMapping(path = "{filmId}")
    public void deleteFilm(@PathVariable("filmId") Long filmId){
        filmService.deleteFilm(filmId);
    }
    /*
    localhost:8080/api/v1/film/{id} şeklinde delete atıyoruz postmandan
     */
    @PutMapping(path = "{filmId}")
    public void updateFilm(@PathVariable("filmId") Long filmId,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) String name
    ) {
        filmService.updateFilm(filmId,genre,name);
    }
    /*
    localhost:8080/api/v1/film/1?genre=aa&name=ruh -> böyle çağırılır
     */

}
