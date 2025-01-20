package com.databbase.book_management.doa;

import java.util.Optional;
import java.util.List;

import com.databbase.book_management.domain.Book;

public interface BookDoa {
  void create(Book book);
  Optional<Book> findOne(Long id);
  List<Book> find();
}
