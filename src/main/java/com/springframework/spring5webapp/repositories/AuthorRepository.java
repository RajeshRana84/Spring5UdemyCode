package com.springframework.spring5webapp.repositories;

import com.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rajesh on 18-08-2017.
 */
public interface AuthorRepository extends CrudRepository<Author , Long> {
}
