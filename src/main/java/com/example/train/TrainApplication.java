package com.example.train;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;


@SpringBootApplication
@EnableJpaRepositories
public class TrainApplication {


    public static void main(String[] args) {
        SpringApplication.run(TrainApplication.class, args);


        System.out.printf("hello world!");
    }











}
