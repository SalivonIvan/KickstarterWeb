package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.db.CategoryDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.ProjectDaoDbImp;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

    private List<Project> projects;
    private Category category;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initField(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void initField(HttpServletRequest request) {
        int idCategory = Integer.parseInt((String) request.getParameter("id"));
        category = new CategoryDaoDbImp().getCategory(idCategory);
        projects = new ProjectDaoDbImp().getProjectsOfCategory(idCategory);
        request.setAttribute("category", category);
        request.setAttribute("projects", projects);
    }

}
