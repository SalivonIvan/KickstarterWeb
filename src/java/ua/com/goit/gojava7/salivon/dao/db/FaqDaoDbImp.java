package ua.com.goit.gojava7.salivon.dao.db;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.dao.FaqDao;

public class FaqDaoDbImp implements FaqDao {

    @Autowired
    @Qualifier("dataSource1")
    private DataSource dataSource;

    public FaqDaoDbImp() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void saveFaq(Faq faq) {
        String query = "INSERT INTO faq (IdProject, Context) VALUES(?,?)";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.update(query, faq.getIdProject(), faq.getContext());
    }

    @Override
    public List<Faq> getContextFaq(int idProject) {
        String query = "SELECT * FROM faq WHERE IdProject=?";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        return jt.query(query, new FaqMapper(), idProject);
    }

}
