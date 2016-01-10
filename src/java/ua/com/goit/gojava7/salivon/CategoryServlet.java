package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;
import ua.com.goit.gojava7.salivon.dao.db.CategoryDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.PaymentDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.ProjectDaoDbImp;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

    private List<Project> projects;
    private Category category;
    Map<Integer, Integer> idProjectTotal = new HashMap<>();

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
        createMap(projects);
        request.setAttribute("category", category);
        request.setAttribute("projects", projects);
        request.setAttribute("mapTotal", idProjectTotal);
    }

    protected void createMap(List<Project> projects) {
        PaymentDao dao = new PaymentDaoDbImp();
        projects.stream().forEach((project) -> {
            idProjectTotal.put(project.getIdProject(), dao.getTotal(project.getIdProject()));
        });

    }

}
