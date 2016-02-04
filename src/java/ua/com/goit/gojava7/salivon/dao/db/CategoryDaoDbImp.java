package ua.com.goit.gojava7.salivon.dao.db;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.dao.CategoryDao;

public class CategoryDaoDbImp implements CategoryDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    static Logger log = LogManager.getLogger(QuoteDaoDbImp.class);

    public CategoryDaoDbImp() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public List<Category> getAllCategories() {
        log.info("create empty list categories");
        List<Category> categories;
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String query = "SELECT IdCategory, Name FROM category ORDER BY name";
        categories = jt.query(query, new CategoryMapper());
        log.info("return list categories");
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String query = "SELECT * FROM category WHERE IdCategory = ?";
        requestedCategory = jt.queryForObject(query, new CategoryMapper(), idCategory);
        log.info("return request category");
        return requestedCategory;
    }

}
