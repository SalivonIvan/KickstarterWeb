package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ua.com.goit.gojava7.salivon.beans.Quote;

public class QuoteMapper implements RowMapper<Quote> {

    @Override
    public Quote mapRow(ResultSet rs, int i) throws SQLException {
        Quote quote = new Quote();
        quote.setText(rs.getString("Text"));
        quote.setAuthor(rs.getString("Author"));
        return quote;
    }

}
