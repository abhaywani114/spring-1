package com.databbase.book_management.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.databbase.book_management.entities.Author;
import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
  List<Author> findByAgeLessThanEqual(int age);
}
