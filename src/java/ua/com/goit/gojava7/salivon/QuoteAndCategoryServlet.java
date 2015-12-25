package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.dao.db.CategoryDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.QuoteDaoDbImp;

@WebServlet(name = "QuteAndCategoryServlet", urlPatterns = {""})
public class QuoteAndCategoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Quote quote = new QuoteDaoDbImp().getRandomQuote();
        List<Category> categories = new CategoryDaoDbImp().getAllCategories();
        request.setAttribute("quote", quote);
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
