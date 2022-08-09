package com.example.film;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class FilmServiceTest {
    @Mock
    private FilmRepository filmRepository;
    private AutoCloseable autoCloseable;
    private FilmService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FilmService(filmRepository); // tüm metodlara ulasmak için.
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Disabled
    void canGetFilms() {
        //when
        underTest.getFilms();
        //then
        verify(filmRepository).findAll();

    }

    @Test
    //@Disabled
    void canAddNewFilm() {
        //given
        Film film = new Film(11L,"melis","aksiyon", LocalDate.of(2015,04,22),10.0);
        //when
        underTest.addNewFilm(film);
        //then
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        Film capturedFilm = filmArgumentCaptor.getValue();
        assertThat(capturedFilm).isEqualTo(film);
    }
    @Test
    //@Disabled
    void canDeleteFilm() {
        //given
        Film film = new Film(1L,
                "Ruhların Kaçışı",
                "animasyon",
                LocalDate.of(2011, Month.JUNE,12),
                8.8
        );
       Long id = film.getId();
       given(filmRepository.existsById(id)).willReturn(true);
        //when
        underTest.deleteFilm(id);
        //then
        verify(filmRepository).deleteById(id);
    }

//    @Test
//    @Disabled
//    void updateFilm() {
//        //given
//        Film ruhlar_bolgesi = new Film(
//                1L,
//                "Ruhlar bÖlgesi",
//                "Korku",
//                LocalDate.of(2016, Month.FEBRUARY,20),
//                9.1
//        );
//        Long id = ruhlar_bolgesi.getId();
//        String name = ruhlar_bolgesi.getName();
//        String genre = ruhlar_bolgesi.getGenre();
//        given(filmRepository.existByName(name)).willReturn(true);
//        //given(filmRepository.existByGenre(genre)).willReturn(true);
//        //when
//        underTest.updateFilm(id,genre,name);
//        //then
//        verify(filmRepository).save(ruhlar_bolgesi);
//    }
}