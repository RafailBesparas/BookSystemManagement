🗂️ Phase 1: Set Up Base Architecture
Technologies:

JavaFX for the GUI

SQLite (via JDBC) for database

MVC pattern: model (Book), view (GUI), controller (logic)

🔧 Phase 2: Book Features (Core Functionality)
✅ CRUD (Create, Read, Update, Delete)
Each book will have:

Title (String)

Author (String)

ISBN (String)

Genre (String)

Read Status (Boolean)

Date Added (LocalDate)

✅ Search
Search bar in the GUI

Filter books by title, author, or ISBN

✅ Sort
Combo box: sort by title, date added, or author

🗃️ Phase 3: Database Integration
Use SQLite to persist book records

Create a BookDAO (Data Access Object) for all DB operations

Store books in a table books with appropriate columns

🖼️ Phase 4: GUI Design (JavaFX)
Main View:
TableView to list books

Buttons: Add Book, Edit, Delete, Refresh

Search Bar + Filter Dropdown

Status/Log label

Dialog Windows:
Add/Edit Book pop-up with form fields

