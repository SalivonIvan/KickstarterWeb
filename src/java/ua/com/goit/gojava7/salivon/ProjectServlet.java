package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.db.PaymentDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.ProjectDaoDbImp;

@WebServlet(name = "ProjectServlet", urlPatterns = {"/project"})
public class ProjectServlet extends HttpServlet {

    private Project project;
    private int total;
    private int countBackers;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initField(request);
        HttpSession session = request.getSession();
        session.setAttribute("idProject", project.getIdProject());
        request.setAttribute("project", project);
        request.setAttribute("total", total);
        request.setAttribute("countBackers", countBackers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("project.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void initField(HttpServletRequest request) {
        String param = request.getParameter("id");
        int idProject;
        if (param == null) {
            idProject = ((int) request.getSession().getAttribute("idProject"));
        } else {
            idProject = Integer.parseInt(request.getParameter("id"));

        }
        project = new ProjectDaoDbImp().getProject(idProject);
        total = new PaymentDaoDbImp().getTotal(idProject);
        countBackers = new PaymentDaoDbImp().getCountBackers(idProject);
    }

}
