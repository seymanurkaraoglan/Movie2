package com.example.film;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    CommandLineRunner commandLineRunner(FilmRepository repository){
        return args -> {
            Film ruhlarin_kacisi = new Film(
                    1L,
                    "Ruhların Kaçışı",
                    "animasyon",
                    LocalDate.of(2011, Month.JUNE,12),
                    8.8
            );
            Film ruhlar_bolgesi = new Film(
                    2L,
                    "Ruhlar bÖlgesi",
                    "Korku",
                    LocalDate.of(2016, Month.FEBRUARY,20),
                    9.1
            );
            repository.saveAll(
                    List.of(ruhlarin_kacisi,ruhlar_bolgesi)
            );
        };

    }
























}
