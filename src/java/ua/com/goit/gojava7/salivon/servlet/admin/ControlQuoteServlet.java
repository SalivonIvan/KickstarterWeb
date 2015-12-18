package ua.com.goit.gojava7.salivon.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.dao.db.QuoteDaoDbImp;

@WebServlet(name = "ControlQuoteServlet", urlPatterns = {"/controlQuote"})
public class ControlQuoteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text = request.getParameter("text").trim();
        String author = request.getParameter("author").trim();
        if (validate(text, author)) {
            Quote quote = new Quote();
            quote.setText(text);
            quote.setAuthor(author);
            QuoteDaoDbImp dao = new QuoteDaoDbImp();
            dao.addQuote(quote);
            response.sendRedirect("admin/controlQuotes.html");

        } else {
            response.sendRedirect("admin/controlQuotes.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public boolean validate(String text, String author) {

        return !text.isEmpty() && !author.isEmpty();
    }

}
