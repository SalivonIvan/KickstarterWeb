package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

@WebServlet(name = "QuteAndCategoryServlet", urlPatterns = {""})
public class QuoteAndCategoryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String dataType = context.getInitParameter("mode");
        switch (dataType) {
            case "file":
                context.setAttribute("mode", DataType.FILE);
                break;
            case "memory":
                context.setAttribute("mode", DataType.MEMORY);
                break;
            case "db":
                context.setAttribute("mode", DataType.DB);
                break;
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataType dataType = (DataType) getServletContext().getAttribute("mode");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Kickstarter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + "Welcome Kickstarter" + "</h1>");
            out.println("<h3>" + DaoFactory.getQuoteDao(dataType).getRandomQuote() + "</h3>");
            out.println("<h2>" + "Categories" + "</h2>");
            out.println("<ul>");
            for (int i = 0; i < DaoFactory.getCategoryDao(dataType).getAllCategories().size(); i++) {
                out.println("<li><a href='kickstarter/category?id=" + DaoFactory.getCategoryDao(dataType).getAllCategories().get(i).getId()
                        + "'>" + DaoFactory.getCategoryDao(dataType).getAllCategories().get(i).getName() + "</a></li>");
            }
            out.println(request.getContextPath());
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
