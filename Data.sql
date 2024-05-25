CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    release_date DATE,
    genre VARCHAR(50),
    language VARCHAR(50),
    qty INT,
    status VARCHAR(20)
);

CREATE TABLE Loans (
    loan_id INT PRIMARY KEY,
    book_id INT,
    user_id INT,
    load_date DATE,
    return_date DATE,
    real_return_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    address VARCHAR(255),
    role VARCHAR(50),
    profile_picture VARCHAR(255),
    status VARCHAR(20)
);


CREATE TABLE Loan_Book (
    loan_id INT,
    book_id INT,
    FOREIGN KEY (loan_id) REFERENCES Loans(loan_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

CREATE TABLE Loan_User (
    loan_id INT,
    user_id INT,
    FOREIGN KEY (loan_id) REFERENCES Loans(loan_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);