package ua.com.goit.gojava7.salivon.dao.db;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.ProjectDao;

public class ProjectDaoDbImp implements ProjectDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    public ProjectDaoDbImp() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public List<Project> getProjectsOfCategory(int idCategory) {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        List<Project> projects;
        String query = "SELECT * FROM project WHERE IdCategory = ?";
        projects = jt.query(query, new ProjectMapper(), idCategory);
        return projects;
    }

    @Override
    public Project getProject(int idProject) {
        Project requestedProject = null;
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String query = "SELECT * FROM project WHERE IdProject =?";
        requestedProject = jt.queryForObject(query, new ProjectMapper(), idProject);
        return requestedProject;
    }

}
