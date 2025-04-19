package org.example;

// Necessary files
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

// Utility class for file handling and direction operations
public class DirectoryManager {

    // Method to list all files and directories in the given path
    public static void listFilesAndDirectories(String directoryPath) {
        //Creating a file object of the given class
        File directory = new File(directoryPath);
        //List all the files and subdirectories
        File[] files = directory.listFiles();

        //If no files where found or directory is empty
        if (files == null || files.length == 0) {
            System.out.println("No files or directories found in: " + directoryPath);
        }
        else {
            // Print the name of each file and directory
            for(File file: files){
                System.out.println(file.getName());
            }
        }
    }

    // Create a directory if it does not exist already
    public static void createDirectory(String directoryPath) {
        //Create a file object
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            // Create the directory if does not exist
            if(directory.mkdirs()){
                System.out.println("Directory created: " + directoryPath);
            }else {
                System.out.println("Failed to create directory: " + directoryPath);
            }
        }
        // Print the directory path if it already exists
        else {
            System.out.println("Directory already exists:" + directoryPath);
        }
    }

    // Rename an existing directory to a new name
    public static void renameDirectory(String currentDirectory, String newDirectory) {
        // Original directory
        File oldDir = new File(currentDirectory);

        // New target directory
        File newDir = new File(newDirectory);

        // Check the nameof the directory if it exists print it cannot rename
        if (newDir.exists()) {
            System.out.println("Cannot rename. Target directory already exists" + newDirectory);
        } else if (!oldDir.renameTo(newDir)) {
            System.out.println("Failed to rename directory");
        // If no problem rename the directory
        }else {
            System.out.println("Directory renamed succussfully to: "+ newDirectory);
        }
    }

    // Copy all files from the source directory to the destination directory
    public static void copyFiles(String sourceDir, String destDir) {
        // Path o the source directory
        Path sourcePath = Paths.get(sourceDir);
        // Path of the destination directory
        Path destPath = Paths.get(destDir);

        try {
            //Create the destination directory if it does not exist
            if (!Files.exists(destPath)) {
                Files.createDirectories(destPath);
            }

            // Create the object sourceDirectory
            File sourceDirectory = new File(sourceDir);
            //Get files to copy
            File[] files = sourceDirectory.listFiles();
            if(files != null){
                for(File file: files){
                    //Destination file path
                    Path destFile = destPath.resolve(file.getName());
                    //Copy file and overwrite if it does already exists
                    Files.copy(file.toPath(), destFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copied: " + file.getName());
                }
            }
        }
        catch(IOException e){
            // Handle file related exceptions
            System.out.println(e.getMessage());
        }
    }

    // Delete the file by its name or path
    public static void deleteFile(String fileName) {
        //File object
        File file = new File(fileName);

        // If deleting the file successfull
        if (file.delete()) {
            System.out.println("File deleted successfully: " + fileName);
        }
        // Failed to delete
        else {
            System.out.println("Failed to delete files: " + fileName);
        }
    }

}

