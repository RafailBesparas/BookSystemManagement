package org.example.dao;

//Important dependencies to include
import org.example.model.Book;
import org.example.util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//BookDao handles all interactions with the books in the database
//This class is responsible for methods to create, insert, retrieve, update and delete books.

public class BookDAO {
    //Constructor to initialize the database if it does not exist
    public BookDAO(){
        try(Connection conn = DatabaseHelper.connect();
            Statement stmt = conn.createStatement()){

            //SQL Query
            // Create books table if it does not exist already
            String sql = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT NOT NULL," +
                    "author TEXT," +
                    "isbn TEXT," +
                    "genre TEXT," +
                    "read BOOLEAN" +
                    ")";
            stmt.execute(sql); // execute the table created
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieves all the books from the database
    public List<Book> getAllBooks(){
        // Create an array list of book objects
        List<Book> books = new ArrayList<>();
        //SQL statement
        String sql = "SELECT * FROM books";
        //Initialize the connection, execute the statement, bring the results from the statement
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            //Loop through the results from the Query of returning all the books
            //Add each book on the list
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getString("genre"),
                        rs.getBoolean("read")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    //Inserts a book into the database
    public void insertBook(Book book) {
        //SQL query for inserting books into the database
        String sql = "INSERT INTO books(title, author, isbn, genre, read) VALUES (?, ?, ?, ?, ?)";
        //Initializing the database connection
        try (Connection conn = DatabaseHelper.connect();
             //Java JDBC Java Database Connectivity
             //This creates a PreparedStatement object pstmt from the database Connection object conn
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Sets the 1st parameter in the SQL query to the book's title
            pstmt.setString(1, book.getTitle());
            // Sets the 2nd paramenter in the SQL query to the books Author..
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.setString(4, book.getGenre());
            pstmt.setBoolean(5, book.isRead());
            //Excecutes the SQL query
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Updates an existing book object in the database

    public void updateBook(Book book) {
        //SQL query to update the books attributes
        String sql = "UPDATE books SET title=?, author=?, isbn=?, genre=?, read=? WHERE id=?";
        //Initializing the database connections
        try (Connection conn = DatabaseHelper.connect();
             //Get from the query the title..... and excecute the query
             // This is also a JDBC object
             // This creates a PreparedStatement object pstmt from the database Connection object conn
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.setString(4, book.getGenre());
            pstmt.setBoolean(5, book.isRead());
            pstmt.setInt(6, book.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a books from the database using its ID
    public void deleteBook(int id) {
        //Query to delete the object based on the ID
        String sql = "DELETE FROM books WHERE id=?";
        //Tries to open a connection to the database using a helper method.
        try (Connection conn = DatabaseHelper.connect();
             // Creates a PreparedStatement using the sql string.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Binds the id passed to the method as the first parameter in the SQL query.
            //Replaces the ? in the query to the ID
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }


