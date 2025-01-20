package com.databbase.book_management.doa;

import java.util.Optional;
import java.util.List;


import com.databbase.book_management.domain.Author;

public interface AuthorDoa {
  void create(Author author);
  Optional<Author> findOne(Long id);
  List<Author> find();
}
