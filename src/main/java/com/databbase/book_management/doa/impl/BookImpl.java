package com.databbase.book_management.doa.impl;

import com.databbase.book_management.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.databbase.book_management.doa.BookDoa;

import java.util.List;

@Component
public class BookImpl implements BookDoa {
  final JdbcTemplate jdbcTemplate;

  BookImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void create(Book book) {
    jdbcTemplate.update(
      "INSERT INTO books (id, title, author_id) VALUES (?, ?, ?)",
      book.getId(),
      book.getTitle(),
      book.getAuthor_id()
    );
  }

  public Optional<Book> findOne(Long id) {
    List<Book> result =  jdbcTemplate.query(
      "SELECT id, title, author_id FROM books WHERE id=? LIMIT 1",
      new BookRowMaper(),
      id
    );

    return result.stream().findFirst();
  }

  public List<Book> find() {
    return jdbcTemplate.query(
      "SELECT id, title, author_id FROM books",
      new BookRowMaper()
    );
  }

  public static class BookRowMaper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNumber) throws SQLException {
      return Book.builder()
        .id(rs.getLong("id"))
        .title(rs.getString("title"))
        .author_id(rs.getLong("author_id"))
        .build();
    }
  }
}
