DROP TABLE IF EXISTS "books";
DROP SEQUENCE IF EXISTS "books_id_seq";
DROP TABLE IF EXISTS "authors";
DROP SEQUENCE IF EXISTS "authors_id_seq";

create SEQUENCE "authors_id_seq" START 1 INCREMENT 1;

create TABLE "authors" (
  "id" bigint default nextval('authors_id_seq') NOT NULL,
  "name" text,
  "age" integer,
  COnSTRAINT "author_pk" PRIMARY KEY ("id")
);

create SEQUENCE "books_id_seq" START 1 INCREMENT 1;

create TABLE "books" (
  "id" bigint default nextval('books_id_seq') NOT NULL,
  "title" text,
  "author_id" bigint,
  CONSTRAINT "book_pk" PRIMARY KEY ("id"),
  CONSTRAINT "author_fk" FOREIGN KEY("author_id")
    REFERENCES authors("id")
);




