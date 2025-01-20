package com.databbase.book_management;


import com.databbase.book_management.domain.Author;
import com.databbase.book_management.domain.Book;

import java.util.ArrayList;
import java.util.List;


public final class TestDataUtil {
  public static Author generateAuthor() {
    return Author.builder()
      .id(1L)
      .name("Abrar Ajaz")
      .age(10)
      .build();
  }


  public static ArrayList<Author> generateMultipleAuthors() {
    ArrayList<Author> authorList = new ArrayList<Author>();

    authorList.add(
      Author.builder()
        .id(1L)
        .name("Abrar Ajaz")
        .age(10)
      .build()
    );

    authorList.add(
      Author.builder()
        .id(2L)
        .name("Sahil Ajaz")
        .age(10)
      .build()
    );

    authorList.add(
      Author.builder()
        .id(3L)
        .name("Mohsin Ajaz")
        .age(10)
      .build()
    );

    return authorList;
  }

  public static List<Book> generateMultipleBooks() {
    List<Book> bookList = new ArrayList<Book>();

    bookList.add(
      Book.builder()
      .id(1L)
      .title("The Great Ottomans")
      .author_id(1L)
      .build()
    );

    bookList.add(
      Book.builder()
      .id(2L)
      .title("The salves of dark")
      .author_id(1L)
      .build()
    );


    return bookList;
  }

  public static Book generateBook() {
    return  Book.builder()
      .id(10L)
      .title("The Great Ottomans")
      .author_id(1L)
      .build();
  }
}
