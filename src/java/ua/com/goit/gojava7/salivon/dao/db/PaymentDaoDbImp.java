package ua.com.goit.gojava7.salivon.dao.db;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;

public class PaymentDaoDbImp implements PaymentDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    public PaymentDaoDbImp() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void savePayment(Payment payment) {
        String query = "INSERT INTO payment (Name, NumberCard,Total,IdProject) VALUES(?,?,?,?)";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.update(query, payment.getNamePayer(), payment.getNumberCard(), payment.getTotal(), payment.getIdProject());
    }

    @Override
    public int getTotal(int idProject) {
        Integer total;
        String query = "SELECT SUM(total) FROM payment WHERE IdProject=?";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        total = jt.queryForObject(query, Integer.class, idProject);
        if (total == null) {
            return 0;
        } 
        return total;
    }
     @Override
    public int getCountBackers(int idProject) {
        Integer total;
        String query = "SELECT COUNT(idProject) FROM payment WHERE IdProject=?";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        total = jt.queryForObject(query, Integer.class, idProject);
        if (total == null) {
            return 0;
        } 
        return total;
    }

}
