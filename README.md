# sxolion
Book cataloging app.
TODO:
1) Basic CRUD for books and shelves (routes and controllers logic, services) (DONE)
2) Refactor books model, integrate with Google Books API
    (how many fields? i.e., how much info should be stored in database vs pulled from API? Need, at least, a field for selfLink to API record, e.g.:
      https://www.googleapis.com/books/v1/volumes/KXQrAQAAQBAJ
    )
3) Replace current dummy adder form for books with Google Books API search
4) Persist books, shelves in MySQL db
