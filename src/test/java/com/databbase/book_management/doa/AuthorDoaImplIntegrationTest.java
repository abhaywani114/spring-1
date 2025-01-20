package com.databbase.book_management.doa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.databbase.book_management.TestDataUtil;
import com.databbase.book_management.doa.impl.AuthorImpl;
import com.databbase.book_management.domain.Author;

import lombok.extern.java.Log;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode =   DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Log
public class AuthorDoaImplIntegrationTest {
  
  private AuthorImpl underTest;

  @Autowired
  AuthorDoaImplIntegrationTest(AuthorImpl underTest) {
    this.underTest = underTest;
  }

  @Test
  public void testThatAuthorCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.generateAuthor();
    underTest.create(author);
    Optional<Author> foundAuthor = underTest.findOne(1L);
    assertThat(foundAuthor).isPresent();
    assertThat(foundAuthor.get()).isEqualTo(author);
  }

  @Test 
  void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
    ArrayList<Author> authors = TestDataUtil.generateMultipleAuthors();
    authors.stream().forEach(arg -> underTest.create(arg));
    List<Author> data = underTest.find();
    assertThat(data).isNotEmpty();
    assertThat(data).hasSize(authors.size());
    assertThat(data).containsExactly(authors.toArray(new Author[0]));
  }

}
