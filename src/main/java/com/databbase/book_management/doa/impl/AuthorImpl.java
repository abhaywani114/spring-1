package com.databbase.book_management.doa.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import com.databbase.book_management.doa.AuthorDoa;
import com.databbase.book_management.domain.Author;

import java.util.List;

@Component
public class AuthorImpl implements AuthorDoa {
  public final JdbcTemplate jdbcTemplate;

  AuthorImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void create(Author author) {
    this.jdbcTemplate.update(
      "Insert INTO authors (id, name, age) VALUES (?, ?, ?)",
      author.getId(), author.getName(), author.getAge()
    );
  }

  @Override
  public Optional<Author> findOne(Long id) {
    List<Author> result = this.jdbcTemplate.query(
      "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
      new AuthorRowMapper(),
      id
    );
    return result.stream().findFirst();
  }

  @Override
  public List<Author> find() {
    return this.jdbcTemplate.query(
      "SELECT id, name, age FROM authors",
      new AuthorRowMapper()
    );
  }


  public static class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Author.builder()
        .id(rs.getLong("id"))
        .name(rs.getString("name"))
        .age(rs.getInt("age"))
        .build();
    }
  }
}
