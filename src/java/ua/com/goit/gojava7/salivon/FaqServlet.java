package ua.com.goit.gojava7.salivon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.dao.FaqDao;
import ua.com.goit.gojava7.salivon.dao.db.FaqDaoDbImp;

@WebServlet(name = "FaqServlet", urlPatterns = {"/faq"})
public class FaqServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        saveFaq(request);
        response.sendRedirect("project");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void saveFaq(HttpServletRequest request) {
        String contextFaq = request.getParameter("faq");
        FaqDao fDao = new FaqDaoDbImp();
        int idProject = Integer.parseInt(request.getParameter("id"));
        Faq faq = new Faq();
        faq.setContext(contextFaq);
        faq.setIdProject(idProject);
        fDao.saveFaq(faq);
    }
}
