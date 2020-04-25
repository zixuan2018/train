package com.example.train.Controller;

import com.example.train.Entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@EnableAutoConfiguration
public class MainController{

    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping("/")
    @Transactional
    public String index(Model model) {


        UserEntity userEntity=new UserEntity();
        userEntity.setName("admin0");
        userEntity.setPassword("admin0");
        sessionFactory.getCurrentSession().save(userEntity);
        sessionFactory.getCurrentSession().flush();






        return "myindex";
    }






}
