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
    public Book(int id, String title, String author, String isbn, String genre, boolean read) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
        this.genre = genre;
        this.read = read;
    }

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

    // toString method for easy printing the book object and its attributes
    //@Override
    //public String toString(

    //) {
    //    return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
    //}


    // A static method for serializing a book object and save it to a file
    //public static void serializeBook(Book book, String filePath) {
        //Try with block in order to close the resources automatically
        //Create a file input stream to write binary data to the specific files
      //  try (
        //        FileOutputStream fileOut = new FileOutputStream(filePath);
                //Write java object
          //      ObjectOutputStream out = new ObjectOutputStream(fileOut))
        //{
            //Serialize the book and write it to the input stream
          //  out.writeObject(book);
          //  System.out.println("Book serialized successfully into a: " + filePath);
        //}
        //Catch any IO exceptions
        //catch (IOException e) {
            //Print the stacktrace to help identify the issues
          //  e.printStackTrace();

    //    }
    //}

    // A static method for deserialiazes a Book object from a file
    //public static Book deserializeBook(String filePath) {
        //Vaiable to hold the deseirialized object
      //  Book book = null;

        // Creating a file input stream to read raw bytes
        //try (FileInputStream fileIn = new FileInputStream(filePath);
             // Read java object
          //   ObjectInputStream in = new ObjectInputStream(fileIn)) {

            //Read and object and cast it into a book
            //book = (Book) in.readObject();
            //System.out.println("Book deserialized successfully from: "+ filePath);
        //}
        //Catch block to handle I/O exceptions and missing class definitions
        //catch (IOException | ClassNotFoundException e) {
            //Print the stack to help with debugging
          //  e.printStackTrace();
       // }
        // Return the deserialized Book object
        //return book;
    //}

}
