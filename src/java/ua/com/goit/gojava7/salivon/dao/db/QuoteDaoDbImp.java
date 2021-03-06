package ua.com.goit.gojava7.salivon.dao.db;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.dao.QuoteDao;

public class QuoteDaoDbImp implements QuoteDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    static Logger log = LogManager.getLogger(QuoteDaoDbImp.class);

    public QuoteDaoDbImp() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public void addQuote(Quote quote) {

        String sql = "INSERT INTO quote (Text, Author) values (?, ?)";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.update(sql, quote.getText(), quote.getAuthor());
        log.info("add quote");
        log.debug("add quote");
    }

    @Override
    public Quote getRandomQuote() {
        String query = "SELECT Text, Author FROM quote ORDER BY rand()LIMIT 1";
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        Quote quote = null;
        quote = jt.queryForObject(query, new QuoteMapper());
        log.info("add random quote");
        log.debug("add random quote");
        return quote;

    }

}
