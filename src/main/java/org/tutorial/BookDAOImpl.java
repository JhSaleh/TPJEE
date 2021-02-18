package org.tutorial;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{
    Connection connexion;
    Statement statement;
    ResultSet resultSet;
    List<Book> bookList;

    public BookDAOImpl() {
        try{
            //Récupère une connexion de type Connection
            this.connexion = DBManager.getInstance().getConnection();
            //Création d'un statement a partir d'une connection
            this.statement = connexion.createStatement();

            createTableBooks(this.statement);
            System.out.println("Table created !");
            fillBookTable(this.statement);
            System.out.println("Table filled !");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> findByAll(){
        try {
            this.resultSet = this.statement.executeQuery("select * from `Book`");
            System.out.println(this.resultSet);

            //itération sur chaque lignes de la table construire les livres
            this.bookList = new ArrayList<>();
            Book book;

            while (resultSet.next()) {
                book = new Book(resultSet.getInt("idBook"), resultSet.getString("titre"), resultSet.getString("author"));
                bookList.add(book);
            }
        } catch ( SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }

    public static void createTableBooks(Statement statement) throws SQLException {
        int test0 = statement.executeUpdate("DROP TABLE IF EXISTS `Book`;");
        int test = statement.executeUpdate("CREATE TABLE `Book` (" +
                "`idBook` int NOT NULL AUTO_INCREMENT," +
                "`titre` varchar(45) NOT NULL," +
                "`author` varchar(45) NOT NULL," +
                "PRIMARY KEY (`idBook`));");
    }

    public static void fillBookTable(Statement statement) throws SQLException {
            int fill = statement.executeUpdate("insert into `Book` values(NULL, 'Harry Potter', 'JKR');");
            int fill2 = statement.executeUpdate("insert into `Book` values(NULL, 'Harry Potter2', 'JKR');");
            int fill3 = statement.executeUpdate("insert into `Book` values(NULL, 'Harry Potter3', 'JKR');");
            int fill4 = statement.executeUpdate("insert into `Book` values(NULL, 'Harry Potter4', 'JKR');");
    }

    @Override
    public List<Book> findByTitle(String searchText) {
        try {

            searchText = "'%"+searchText+"%'"; //pour permettre la recherche par mots

            ArrayList<Book> booksResult = new ArrayList<>();

            System.out.println("SELECT * FROM Book WHERE Book.titre LIKE " + searchText + ";");
            ResultSet result = this.statement.executeQuery("SELECT * FROM Book WHERE Book.titre LIKE " + searchText + ";");
            System.out.println(result.next());

            while (result.next()){
                System.out.println(result.getString("titre"));
                booksResult.add(new Book(result.getInt("idBook"), result.getString("titre"), result.getString("author")));
            }

            return booksResult;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null; //Cas d'échec
    }
}
