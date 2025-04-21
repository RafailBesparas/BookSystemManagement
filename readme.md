# 📚 Book Management System (JavaFX + SQLite)

A desktop-based application to manage a collection of books using JavaFX and SQLite. Supports adding, editing, deleting, and viewing books via a modern GUI.

---

## 🚀 Features

- ✅ Add, edit, delete book entries
- ✅ View books in a JavaFX TableView
- ✅ Persistent storage with SQLite
- ✅ Tracks title, author, ISBN, genre, and read/unread status
- ✅ Modal dialog forms for clean data entry
- ✅ Refreshable and interactive UI

---

## 🏗️ Technologies Used

- Java 17+
- JavaFX 21
- SQLite (via `sqlite-jdbc`)
- Maven (for build and dependency management)

---

🧪 Usage
Click Add to enter new book information.

Select a book and click Edit to update it.

Select a book and click Delete to remove it.

Click Refresh to reload the data from the database.

Each book contains:

Title

Author

ISBN

Genre

Read/Unread status (checkbox)

📂 Database
SQLite file: books.db will be created automatically in the root directory.

Table: books(id, title, author, isbn, genre, read)

✅ TODO / Upcoming Features
🔍 Search and filter functionality

⬇️ Export/Import to/from JSON or CSV

🧾 Sorting by title/author/date

📁 Backup and restore

🌐 Cloud sync or REST API

🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss.

📄 License
This project is open source and available under the MIT License.
