package org.tutorial;

import java.util.List;

public interface BookDAO {
    public List<Book> findByAll();

    public List<Book> findByTitle(String searchText);
}
