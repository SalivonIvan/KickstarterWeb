package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ua.com.goit.gojava7.salivon.beans.Project;

public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet rs, int i) throws SQLException {
       Project project = new Project();
       project.setIdProject(rs.getInt("IdProject"));
       project.setIdCategory(rs.getInt("IdCategory"));
       project.setTitle(rs.getString("Title"));
       project.setTotal(rs.getInt("Total"));
       project.setDescription(rs.getString("Description"));
       project.setHistoryProject(rs.getString("HistoryProject"));
       project.setDateStart(rs.getDate("DateStart"));
       project.setPoster(rs.getString("Poster"));
       project.setNumberOfDaysToImplement(rs.getInt("NumberOfDaysToImplement"));
       return project;
    }

}
