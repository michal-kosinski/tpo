CREATE DATABASE tpo;
USE tpo;
CREATE TABLE IF NOT EXISTS ENTRIES (id INT AUTO_INCREMENT PRIMARY KEY, date DATE, title VARCHAR(255) NOT NULL, content TEXT);
INSERT INTO ENTRIES (date, title, content) VALUES (current_date(), 'Title 1', 'Content 1');
INSERT INTO ENTRIES (date, title, content) VALUES (current_date(), 'Title 2', 'Content 2');
INSERT INTO ENTRIES (date, title, content) VALUES (current_date(), 'Title 3', 'Content 3');