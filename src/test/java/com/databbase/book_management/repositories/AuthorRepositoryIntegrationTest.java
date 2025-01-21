package com.databbase.book_management.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.databbase.book_management.TestDataUtil;
import com.databbase.book_management.entities.Author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext( classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTest {
  private final AuthorRepository underTest;

  @Autowired
  AuthorRepositoryIntegrationTest(AuthorRepository underTest) {
    this.underTest = underTest;
  }

  @Test
  public void TestThatAuthorWithLessThanAgeCanBeRecalled() {
    List<Author> authorsData = TestDataUtil.generateMultipleAuthors();
    underTest.saveAll(authorsData);
    int testAge = 30;
    List<Author> requiredAuthors = authorsData.stream().filter(arv -> arv.getAge() <= testAge).toList();
    List<Author> recalledData = underTest.findByAgeLessThanEqual(testAge);
    assertNotNull(recalledData);
    assertFalse(recalledData.isEmpty());
    assertEquals(recalledData, requiredAuthors);   
  }

}
