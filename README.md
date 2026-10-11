# Parquet Shipments - Java Application

This is a Java desktop application based on a **Client-Server** architecture, designed for tracking and managing parquet shipments. The project demonstrates a simulation of a distributed system where multiple clients communicate with a central server for data processing and database persistence.

## 🛠 Technologies and Dependencies

* **Language:** Java (JDK 8+)
* **Database:** MySQL / MariaDB
* **Networking:** Java Sockets (Client-Server communication)
* **GUI:** Java Swing / AWT
* **External Libraries:**
  * `mysql-connector-j` – JDBC driver for MySQL database connectivity.
  * `jcalendar` – Swing components for date selection.
  * `json` – JSON parsing library.

## 📁 Project Structure

The project is structured into three main modules and supporting files:

```
├── 1_PosiljkeParketa_Client/    # Client application (GUI and client-side logic)
├── 1_PosiljkeParketa_Server/    # Server application (Request handling & DB management)
├── PosiljkeParketa_Common/     # Shared models, utilities, and Data Transfer Objects (DTO)
├── mysql-connector-j-9.1.0/    # MySQL JDBC Driver
├── jcalendar-1.4.jar           # Date picker library
├── json-20200518.jar           # JSON library
└── posiljkeBaza.sql            # SQL dump for database initialization
```

## ⚙️ Setup and Execution

### 1. Database Setup

1. Start your local MySQL server (e.g., via XAMPP, WAMP, or a standalone MySQL instance).
2. Import the `posiljkeBaza.sql` file into your MySQL DBMS to generate the schema and seed data:
   ```bash
   mysql -u root -p < posiljkeBaza.sql
   ```

### 2. Connection Configuration

Ensure that the database credentials (URL, username, password) inside the server project (`1_PosiljkeParketa_Server`) match your local database settings.

### 3. Execution Order

1. **Start the Server:** Launch the `1_PosiljkeParketa_Server` application first. It will listen for incoming client socket connections.
2. **Start the Client:** Once the server is running, launch the `1_PosiljkeParketa_Client` application to access the user interface.

## 📝 Key Features

* User authentication and login system.
* Create, update, and search parquet shipment records.
* Multithreaded server handling multiple concurrent client requests.
* Interactive graphical interface with date pickers and data tables.

## 🔒 Security Note

This repository is built for educational and demonstration purposes using **mock data** designed to run on a local environment (`localhost`).
