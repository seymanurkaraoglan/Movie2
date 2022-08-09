package com.example.film;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class FilmRepositoryTest {
    @Autowired
    private FilmRepository underTest;
    @AfterEach
    void tearDown() {
    //underTest.deleteAll();
    }

    @Test
void findFilmByName() {
    //given
    String name = "film";
    Film film = new Film(
            11L,name,"der", LocalDate.of(2015, Month.JUNE,15),5.0
    );
    underTest.save(film);
    //when
    Optional<Film> excepted = underTest.findFilmByName(name); //burda bi bokluk var
    //then
    assertThat(excepted).isNotEmpty();

}
}