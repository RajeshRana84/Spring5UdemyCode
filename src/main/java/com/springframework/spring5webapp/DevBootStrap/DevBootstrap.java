package com.springframework.spring5webapp.DevBootStrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Rajesh on 18-08-2017.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric","Evans");
        Publisher publisher = new Publisher("Worx","New Jersey");
        Book ddd = new Book("Domain Driven Design" , "1234" , publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J@EE Development","23455",publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
