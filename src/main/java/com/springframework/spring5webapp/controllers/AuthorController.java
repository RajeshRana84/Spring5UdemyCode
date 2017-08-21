package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rajesh on 21-08-2017.
 */
@Controller
public class AuthorController {

    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors" , authorRepository.findAll());
        return "authors";
    }
}