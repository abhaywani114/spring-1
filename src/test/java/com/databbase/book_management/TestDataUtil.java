package com.databbase.book_management;


import com.databbase.book_management.entities.Author;
import com.databbase.book_management.entities.Book;

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
        .name("Abrar Ajaz")
        .age(10)
      .build()
    );

    authorList.add(
      Author.builder()
        .name("David Ajaz")
        .age(25)
      .build()
    );

    authorList.add(
      Author.builder()
        .name("Sahil Ajaz")
        .age(20)
      .build()
    );

    authorList.add(
      Author.builder()
        .name("Mohsin Ajaz")
        .age(30)
      .build()
    );

    authorList.add(
      Author.builder()
        .name("Sahil Ajaz")
        .age(32)
      .build()
    );

    authorList.add(
      Author.builder()
        .name("Sahil Ajaz")
        .age(40)
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
      .build()
    );

    bookList.add(
      Book.builder()
      .id(2L)
      .title("The salves of dark")
      .build()
    );


    return bookList;
  }

  public static Book generateBook() {
    return  Book.builder()
      .id(10L)
      .title("The Great Ottomans")
      .build();
  }
}
