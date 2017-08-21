package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rajesh on 18-08-2017.
 */
@Controller
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getbooks(Model model){
        model.addAttribute("books" , bookRepository.findAll());
        return "books";
    }
}
