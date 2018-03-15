# sxolion
Book cataloging app.
TODO:
1) Basic CRUD for books and shelves (routes and controllers logic, services) (DONE)
2) Replace dummy books model with Google Books API call
    (final product should have just four fields: id, created_at, updated_at, and selfLink to API record, e.g.:
      https://www.googleapis.com/books/v1/volumes/KXQrAQAAQBAJ
    )
3) Replace current dummy adder for books with Google Books API search
4) Hook book, shelf models up to MySQL db
