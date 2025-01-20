package com.databbase.book_management.doa;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.databbase.book_management.TestDataUtil;
import com.databbase.book_management.doa.impl.BookImpl;
import com.databbase.book_management.domain.Book;

@ExtendWith(MockitoExtension.class)
public class BookDoaImplTest {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private BookImpl underTest;

  @Test
  public void testIfCreateBookGeneratesCorrectSql() {
    Book book = TestDataUtil.generateBook();

      underTest.create(book);


    verify(jdbcTemplate).update(
      eq("INSERT INTO books (id, title, author_id) VALUES (?, ?, ?)"),
      eq(10L),
      eq("The Great Ottomans"),
      eq(1L)
    );
  }

  @Test
  public void testOfBookFindOneGeneratedCorrectSql() {
    underTest.findOne(10L);
    verify(jdbcTemplate).query(
      eq("SELECT id, title, author_id FROM books WHERE id=? LIMIT 1"),
      any(BookImpl.BookRowMaper.class),
      eq(10L)
    );
  }

  @Test
  public void testThatBookFindGeneratesCorrectSql() {
    underTest.find();
    verify(jdbcTemplate).query(
      eq("SELECT id, title, author_id FROM books"),
      any(BookImpl.BookRowMaper.class)
    );
  }
  
}
