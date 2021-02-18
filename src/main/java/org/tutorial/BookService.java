package org.tutorial;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public List<Book> getBooksByTitle(String searchText);
}
