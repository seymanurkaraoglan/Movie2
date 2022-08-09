package com.example.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
@Table(name = "films")
public class Film {
    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "film_sequence"
    )
    //@Transient -> bu anotasyon veri tabanında böyle bir sütun olmadan hesaplama yapar.mesela son giriş
    //zamanı veya otomatik yaş hesaplama gibi.
    /*
     * mesela age hesaplayacak olsak getAge() içinde return Period.between(this.dob,LocalDate.now()).getYears();
     * */
    private Long id; //sitedeki idsi
    private String name; //adı
    private String genre; //türü
    private LocalDate rof; //filmin çıkış tarihi
    private Double rating; //puanı
    public Film(){}

    public Film(Long id,
                String name,
                String genre,
                LocalDate rof,
                Double rating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.rof = rof;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getRof() {
        return rof;
    }

    public void setRof(LocalDate rof) {
        this.rof = rof;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
