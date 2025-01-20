package com.databbase.book_management.doa;

import com.databbase.book_management.TestDataUtil;
import com.databbase.book_management.doa.impl.AuthorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.databbase.book_management.domain.Author;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import  org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AuthorDoaImplTest {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private AuthorImpl underTest;

  @Test
  public void testThatCreateAuthorGeneratesCorrectSql() {
    Author author = TestDataUtil.generateAuthor();

    underTest.create(author);
    verify(jdbcTemplate).update(
      eq("Insert INTO authors (id, name, age) VALUES (?, ?, ?)") ,
      eq(1L),
      eq("Abrar Ajaz"),
      eq(10)
    );
  }

  @Test
  public void testThatFindOneGeneratesCorrectSql() {
    underTest.findOne(1L);
    verify(jdbcTemplate).query(
      eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
      any(AuthorImpl.AuthorRowMapper.class),
      eq(1L)
    );
  }

  @Test
  public void testThatFindAuthorGeneratesCorrectSql() {
    underTest.find();
    verify(jdbcTemplate).query(
      eq("SELECT id, name, age FROM authors"),
      any(AuthorImpl.AuthorRowMapper.class)
    );
  }
}
