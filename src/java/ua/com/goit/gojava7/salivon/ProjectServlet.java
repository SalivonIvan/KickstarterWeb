package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

@WebServlet(name = "ProjectServlet", urlPatterns = {"/project"})
public class ProjectServlet extends HttpServlet {

    Project project;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initField(request);
        HttpSession session = request.getSession();
        int idProject = project.getId();
        session.setAttribute("idProject", idProject);
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
            out.println("<form action=\"faq?id=\""+project.getId()+"\" method=\"post\">\n"
                    + "            <p>Enter your questions:</p>\n"
                    + "            <textarea name=\"faq\" rows=\"10\" cols=\"60\" >\n"
                    + "            </textarea><br>\n"
                    + "            <input type=\"submit\" value=\"Submit\" />\n"
                    + "        </form>\n"
                    + "        <form action=\"payment\">\n"
                    + "            <p>select payment method</p>\n"
                    + "            <input type=\"radio\" name=\"payment\" value=\"1$\" />Make a contribution of 1$<br>\n"
                    + "            <input type=\"radio\" name=\"payment\" value=\"10$\" />Make a contribution of 10$<br>\n"
                    + "            <input type=\"radio\" name=\"payment\" value=\"40$\" />Make a contribution of 40$<br>\n"
                    + "            <input type=\"radio\" name=\"payment\" value=\"\" />to contribute in any $<br>\n"
                    + "            <input type=\"submit\" value=\"Submit\" />\n"
                    + "        </form>");
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
