package org.tutorial;

import java.util.List;

public class BookServiceImpl implements BookService {

    //private BookDAO bookDao = new BookDAOMockImpl(); //1er version d'accès à objet
    private BookDAO bookDao = new BookDAOImpl();

    public List<Book> getAllBooks(){
        return bookDao.findByAll();
    }

    public List<Book> getBooksByTitle(String title) {return bookDao.findByTitle(title);}
}

/**
 3.5
 */