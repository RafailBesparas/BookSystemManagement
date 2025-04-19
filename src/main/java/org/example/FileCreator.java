package org.example;

//Import classes for creating a writing
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Utility classes for creating and writing to files
public class FileCreator {
    // Method for creating a file with the given name and content inside the specified directory
    public static void createSampleFile(String directory, String fileName, String content) {
        //Create a File Object using directory and file name
        File file = new File(directory, fileName);
        // Try-with-resources to ensure FileWriter is closed automatically
        try (FileWriter writer = new FileWriter(file)) {
            // Write the provided content int the file
            writer.write(content);
            // Confirm successfull file creation and print the full path
            System.out.println("File created: " + file.getAbsolutePath());
        }
        // Handle I/O exceptions that might occur during file writing
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
