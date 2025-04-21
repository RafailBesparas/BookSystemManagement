package org.example.model;

import java.io.*;


public class Book implements Serializable {

    //Implement this variable for the serialization
    //Used during deserialization to verify the sender and receiver of a serializable object have the same version
    @Serial
    private static final long serialVersionUID = 1L;

    // Class attributes
    private int id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private boolean read;

    // Constructor
    // This constructor is used when you already know the book's id — typically when you're reading from a database.
    public Book(int id, String title, String author, String isbn, String genre, boolean read) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
        this.genre = genre;
        this.read = read;
    }

    // Constructor when we definetely do not know the constructors id yet
    public Book(String title, String author, String isbn, String genre, boolean read) {
        this(-1, title, author, isbn, genre, read);
    }

    // Getters for the title, author, ISbn
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getId() {return id;}
    public String getGenre() {return genre;}
    public boolean isRead() {return read;}

    // Setters for the book attributes
    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setRead(boolean read) {this.read = read;}


}
