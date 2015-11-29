package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

    List<Project> projects;
    Category category;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initField(request);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Kickstarter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>" + "Category - " + category.getName() + "</h2>");
            for (Project list1 : projects) {
                out.println("<h3><a href='project?id=" + list1.getId() + "'>" + list1.getTitle() + "</a></h3><br>");
                out.println("  Description: " + list1.getDescription() + "<br>");
                out.println("  Total " + list1.getTotal() + "$<br>");
                out.println("  Collected amount " + list1.getCollectedAmount() + "$<br>");
                out.println("  Number of days to end " + list1.getNumberOfDaysToEnd() + "<br>");

            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void initField(HttpServletRequest request) {
        DataType dataType = (DataType) getServletContext().getAttribute("mode");
        int idCategory = Integer.parseInt((String) request.getParameter("id"));
        category = DaoFactory.getCategoryDao(dataType).getCategory(idCategory);
        projects = DaoFactory.getProjectDao(dataType).getProjectsOfCategory(idCategory);
    }

}
