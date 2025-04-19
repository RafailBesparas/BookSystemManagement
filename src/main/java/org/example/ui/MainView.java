package org.example.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.dao.BookDAO;
import org.example.model.Book;

public class MainView {
    private BorderPane root;
    private TableView<Book> tableView;
    private ObservableList<Book> bookList;
    private BookDAO dao;

    public MainView() {
        dao = new BookDAO();
        bookList = FXCollections.observableArrayList(dao.getAllBooks());
        tableView = new TableView<>();

        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTitle()));

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getAuthor()));

        TableColumn<Book, String> isbnCol = new TableColumn<>("ISBN");
        isbnCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getIsbn()));

        TableColumn<Book, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getGenre()));

        TableColumn<Book, Boolean> readCol = new TableColumn<>("Read");
        readCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleBooleanProperty(cell.getValue().isRead()));

        tableView.getColumns().addAll(titleCol, authorCol, isbnCol, genreCol, readCol);
        tableView.setItems(bookList);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> showBookDialog(null));

        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> {
            Book selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) showBookDialog(selected);
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Book selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                dao.deleteBook(selected.getId());
                refreshTable();
            }
        });

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> refreshTable());

        HBox buttons = new HBox(10, addButton, editButton, deleteButton, refreshButton);
        buttons.setPadding(new Insets(10));

        root = new BorderPane();
        root.setCenter(tableView);
        root.setBottom(buttons);
    }

    public BorderPane getRoot() {
        return root;
    }

    private void showBookDialog(Book bookToEdit) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle(bookToEdit == null ? "Add New Book" : "Edit Book");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        TextField titleField = new TextField();
        TextField authorField = new TextField();
        TextField isbnField = new TextField();
        TextField genreField = new TextField();
        CheckBox readCheck = new CheckBox("Read");

        if (bookToEdit != null) {
            titleField.setText(bookToEdit.getTitle());
            authorField.setText(bookToEdit.getAuthor());
            isbnField.setText(bookToEdit.getIsbn());
            genreField.setText(bookToEdit.getGenre());
            readCheck.setSelected(bookToEdit.isRead());
        }

        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Author:"), 0, 1);
        grid.add(authorField, 1, 1);
        grid.add(new Label("ISBN:"), 0, 2);
        grid.add(isbnField, 1, 2);
        grid.add(new Label("Genre:"), 0, 3);
        grid.add(genreField, 1, 3);
        grid.add(readCheck, 1, 4);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            Book book = new Book(
                    titleField.getText(),
                    authorField.getText(),
                    isbnField.getText(),
                    genreField.getText(),
                    readCheck.isSelected()
            );
            if (bookToEdit == null) {
                dao.insertBook(book);
            } else {
                book.setId(bookToEdit.getId());
                dao.updateBook(book);
            }
            dialog.close();
            refreshTable();
        });

        grid.add(saveButton, 1, 5);

        Scene scene = new Scene(grid, 400, 300);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    private void refreshTable() {
        bookList.setAll(dao.getAllBooks());
    }

}
