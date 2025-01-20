package com.databbase.book_management.doa;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.databbase.book_management.TestDataUtil;
import com.databbase.book_management.doa.impl.AuthorImpl;
import com.databbase.book_management.doa.impl.BookImpl;
import com.databbase.book_management.domain.Author;
import com.databbase.book_management.domain.Book;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDoaImplIntegrationTest {
  private final BookImpl bookImpl;
  private final AuthorImpl authorImpl;

  @Autowired
  BookDoaImplIntegrationTest(final BookImpl bookImpl, final AuthorImpl authorImpl) {
    this.bookImpl = bookImpl;
    this.authorImpl = authorImpl;
  }

  @Test
  public void testThatIfBookCanBeCreatedAndRecalled() {
    Book book = TestDataUtil.generateBook();
    Author author = TestDataUtil.generateAuthor();
    authorImpl.create(author);
    book.setAuthor_id(author.getId());
    bookImpl.create(book);
    Optional<Book> foundBook = bookImpl.findOne(book.getId());
    assertThat(foundBook).isPresent();
  }

  @Test
  public void testThatIfMultipleBooksCanBeCreatedAndRecalled() {
    List<Book> books = TestDataUtil.generateMultipleBooks();
    authorImpl.create(TestDataUtil.generateAuthor());
    books.stream().forEach(book -> bookImpl.create(book));
    List<Book> data = bookImpl.find();
    assertThat(data).isNotEmpty().hasSize(data.size()).containsExactly(data.toArray(new Book[0]));
  }
} 
