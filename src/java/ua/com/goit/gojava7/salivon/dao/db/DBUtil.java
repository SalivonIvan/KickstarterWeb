package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class DBUtil {

    private Connection connection;
    private Statement statement;
    private ResultSet result;
    @Autowired
    @Qualifier("dataSource")
    private DataSource ds;

    public void openConnection() {

        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        try {
//            try {
                //        try {
//            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
//            statement = connection.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
//            }
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
