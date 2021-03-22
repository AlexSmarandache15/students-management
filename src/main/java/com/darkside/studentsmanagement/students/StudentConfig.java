package com.darkside.studentsmanagement.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (
            StudentRepository repository) {
        return args -> {
            Student alex = new Student("Alex",
                    "Sma", "License",
                    "Calc",
                    LocalDate.of(2001, Month.JANUARY,15)
            );

            Student gb = new Student("GB",
                    "Bad", "License",
                    "Calc",
                    LocalDate.of(2000, Month.JANUARY,15)
            );

            repository.saveAll(List.of(alex, gb));

        };
    }
}
