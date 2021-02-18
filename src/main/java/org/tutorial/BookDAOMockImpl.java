package org.tutorial;

import java.util.*;

/**
 * C'est une classe qui écrit en dur les objets sur le serveur
 */
public class BookDAOMockImpl implements BookDAO {
    @Override
    public ArrayList<Book> findByAll() {
        Book HarryPotter1 = new Book(0, "HarryPotter1", "JKR");
        Book HarryPotter2 = new Book(1, "HarryPotter2", "JKR");
        Book HarryPotter3 = new Book(2, "HarryPotter3", "JKR");
        Book HarryPotter4 = new Book(3, "HarryPotter4", "JKR");

        ArrayList<Book> bibliotheque = new ArrayList<>();

        bibliotheque.add(HarryPotter1);
        bibliotheque.add(HarryPotter2);
        bibliotheque.add(HarryPotter3);
        bibliotheque.add(HarryPotter4);

        return bibliotheque;
    }

    @Override
    public List<Book> findByTitle(String searchText) {
        return null;
    }
}
