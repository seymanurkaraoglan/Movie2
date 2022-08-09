package com.example.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    public void addNewFilm(Film film) {
        Optional<Film> filmByName = filmRepository.findFilmByName(film.getName());
        if (filmByName.isPresent()) {
            throw new IllegalStateException("Bu isimde bir film bulunmaktadır.");

        }
        filmRepository.save(film);
    }


    public void deleteFilm(Long filmId) {
        boolean exists = filmRepository.existsById(filmId);
        if (!exists) {
            throw new IllegalStateException("verilen "
                    + filmId + "ile film bulunamadı");
        }
        filmRepository.deleteById(filmId);
    }
    @Transactional
    public void updateFilm(Long filmId,String genre,String name) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new IllegalStateException(
                        "verilen " + filmId + "id ile film bulunamadı"
                ));
        if(genre != null &&
                genre.length() > 0 &&
                !Objects.equals(film.getGenre(),genre)){
            film.setGenre(genre);
        }
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(film.getRating(),name)){
            Optional<Film> filmOptional = filmRepository
                    .findFilmByName(name);
            if(filmOptional.isPresent()){
                throw new IllegalStateException("isim alındı");
            }
            film.setName(name);
        }


    }
}
