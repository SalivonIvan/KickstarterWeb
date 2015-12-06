package ua.com.goit.gojava7.salivon;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class QuoteAndCategoryServletTest {

    public QuoteAndCategoryServletTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testInit() throws Exception {
        ServletContext context = mock(ServletContext.class);
        QuoteAndCategoryServlet instance = mock(QuoteAndCategoryServlet.class);
        when(instance.getServletContext()).thenReturn(context);
        when(context.getInitParameter("mode")).thenReturn("db");
//        verify(instance).init();

    }

    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        QuoteAndCategoryServlet instance = new QuoteAndCategoryServlet();
        instance.processRequest(request, response);

    }

    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        QuoteAndCategoryServlet instance = new QuoteAndCategoryServlet();
        instance.doGet(request, response);

    }

}
