
package ua.com.goit.gojava7.salivon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ua.com.goit.gojava7.salivon.beans.Payment;

public class PaymentMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet rs, int i) throws SQLException {
       Payment payment = new Payment();
       payment.setIdProject(rs.getInt("IdProject"));
       payment.setNamePayer(rs.getString("Name"));
       payment.setNumberCard(rs.getLong("NumberCard"));
       payment.setTotal(rs.getInt("Total"));
       return payment;
    }
    
}
