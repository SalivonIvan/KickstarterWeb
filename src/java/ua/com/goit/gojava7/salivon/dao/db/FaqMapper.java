package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ua.com.goit.gojava7.salivon.beans.Faq;

public class FaqMapper implements RowMapper<Faq> {

    @Override
    public Faq mapRow(ResultSet rs, int i) throws SQLException {
        Faq faq = new Faq();
        faq.setIdProject(rs.getInt("IdProject"));
        faq.setContext("Context");
        return faq;
    }

}
