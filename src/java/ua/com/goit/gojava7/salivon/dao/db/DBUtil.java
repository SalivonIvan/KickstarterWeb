package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class DBUtil {

    private Connection connection;
    private Statement statement;
    private ResultSet result;
    @Autowired
    private DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public void openConnection() {
//
//        ApplicationContext contextSpring = new XmlWebApplicationContext();
//        ds = contextSpring.getBean("dataSource", DataSource.class);
        try {
            try {
                //        try {
//            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
//            statement = connection.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = ds.getConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int executeUpdate(String query) {
        int rowCount = 0;
        openConnection();
        try {
            rowCount = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
