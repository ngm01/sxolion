# sxolion
Book cataloging app. Java, Spring Boot/Spring MVC. Sxolion, [from the Greek](https://en.wikipedia.org/wiki/Scholia). Users create collections ("shelves") for books. Users add books to shelves; tag shelves and books; search, view, and favorite other users' shelves. Eventually: QR codes to link virtual book collection with physical locations (e.g., which box has which books during a move.)
TODO:
1) Basic CRUD for books and shelves (routes and controllers logic, services) (DONE)
2) Replace current dummy adder form for books with Google Books API search (DONE)
3) Refactor books model, integrate with [Google Books API](https://www.googleapis.com/books/v1/volumes/KXQrAQAAQBAJ) (DONE)
4) Persist books, shelves in MySQL db (BOOKS done, SHELVES next)
5) Book-Shelf join
6) Clean up UI (Bootstrap, jQuery)
7) Tagging
8) Users/login-registration
9) QR codes
