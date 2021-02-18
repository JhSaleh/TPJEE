package org.tutorial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MainServlet extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) {
        BookService bookService = new BookServiceImpl(); //réinstancie la base de donnée à chaque recherche, à changer en ajoutant un flag
        String searchText= request.getParameter("searchText");
        System.out.println(searchText);
        if(searchText == null){
            List<Book> listBooks = bookService.getAllBooks();
            request.setAttribute("listBooks", listBooks); //Permet de transmettre des objets d'un servlet a un autre/ a etre accéder par une page html
        } else {
            List<Book> listBooks = bookService.getBooksByTitle(searchText);
            if(listBooks.size() >= 1) {
                request.setAttribute("listBooks", listBooks); //Permet de transmettre des objets d'un servlet a un autre/ a etre accéder par une page html
            } else {
                listBooks = bookService.getAllBooks();
                request.setAttribute("listBooks", listBooks);
            }
        }

        String pageName = "/accueil.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);

        /*
        //Mettre tous les objets a accéder au début, car le chargement de la page qui suit nécessite ces objets
        BookService bookService = new BookServiceImpl();
        List<Book> listBooks = bookService.getAllBooks();
        request.setAttribute("listBooks", listBooks); //Permet de transmettre des objets d'un servlet a un autre/ a etre accéder par une page html

        String pageName="/accueil.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        */


        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Redirige la demande
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        doProcess(request, response);
    }

    /**
     * Redirige la publication
     * @param request
     * @param response
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        doProcess(request, response);
    }

    /**
     * Permet de rediriger vers la page d'acceuil.jsp alors que l'url est MainServlet
     */

}
