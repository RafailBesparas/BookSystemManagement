package org.example;

// Import the important utility classes
import org.example.Book;
import org.example.DirectoryManager;
import org.example.FileCreator;

import java.io.File;

// Main class demonstrates directory, file and object for serialization operations
public class Main {

    public static void main(String[] args) {

        // Define main and backup directory paths
        String directoryPath = "./myBooks";
        String backupPath = "./BooksBackupDirectory";

        // Make sure the main directory exists before writing files
        DirectoryManager.createDirectory(directoryPath);

        // Sample book titles and authors
        String[] titles = {"The Great Gatsby", "1984", "To Kill a Mockingbird"};
        String[] authors = {"F. Scott Fitzgerald", "George Orwell", "Harper Lee"};

        // Create sample book files
        for (int i = 0; i < titles.length; i++) {
            String fileName = titles[i] + ".txt";
            String content = "Title: " + titles[i] + "\nAuthor: " + authors[i] + "\nSample Content...";
            FileCreator.createSampleFile(directoryPath, fileName, content);
        }

        // List contents
        DirectoryManager.listFilesAndDirectories(directoryPath);

        // Create backup directory
        DirectoryManager.createDirectory(backupPath);

        // Rename backup directory
        DirectoryManager.renameDirectory("./myBooksBackup", backupPath);

        // Copy files to backup
        DirectoryManager.copyFiles(directoryPath, backupPath);

        // Delete a file
        DirectoryManager.deleteFile("./myBooks/1984.txt");

        // Serialize and deserialize book

        //Create the book object
        Book book = new Book("1984", "George Orwell", "978-0451524935");

        //Define path for serialized file
        String bookSerPath = "./myBooks/book.ser";

        // Serialize the book object to a file
        Book.serializeBook(book, bookSerPath);

        //Desirialze the book object from a file
        Book deserializedBook = Book.deserializeBook(bookSerPath);
        System.out.println("Deserialized Book: " + deserializedBook);

    }

}
