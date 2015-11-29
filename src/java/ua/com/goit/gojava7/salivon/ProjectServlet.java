package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

@WebServlet(name = "ProjectServlet", urlPatterns = {"/project"})
public class ProjectServlet extends HttpServlet {

    Project project;

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
            out.println("<h2>" + "Project - " + project.getTitle() + "</h2>");
            out.println("  Description: " + project.getDescription() + "<br>");
            out.println("  Total " + project.getTotal() + "$" + "<br>");
            out.println("  Collected amount " + project.getCollectedAmount() + "$" + "<br>");
            out.println("  Number of days to end " + project.getNumberOfDaysToEnd() + "<br>");
            out.println("  History " + project.getHistoryProject() + "<br>");
            out.println("  Link " + "<a href='project?id=" + project.getId() + "'>" + project.getLink() + "</a><br>");
            out.println("  FAQ " + project.getFaq() + "<br>");
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
        int idProject = Integer.parseInt((String) request.getParameter("id"));
        project = DaoFactory.getProjectDao(dataType).getProject(idProject);

    }

}
