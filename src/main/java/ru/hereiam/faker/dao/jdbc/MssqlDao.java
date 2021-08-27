package ru.hereiam.faker.dao.jdbc;

import ru.hereiam.faker.dao.UserDao;
import ru.hereiam.faker.generators.User;
import ru.hereiam.faker.utils.Property;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class MssqlDao implements UserDao {

    private Connection conn;
    private Statement stmt;

    @Override
    public void connect() {
        Properties prop = Property.load();
        String connectionUrl = prop.getProperty("datasource.url");
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            System.out.println("Connection created");
            this.conn = con;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Optional<User> getUserInfo(Integer id) {
        return Optional.empty();
    }

    @Override
    public void setUsers(List<User> users) {
        try {
            Properties prop = Property.load();
            String connectionUrl = prop.getProperty("datasource.url");
            Connection con = DriverManager.getConnection(connectionUrl);
            con.setAutoCommit(false);
            PreparedStatement psmt = con.prepareStatement("INSERT INTO [User] (firstname,lastname,password,address,age,login) VALUES(?,?,?,?,?,?)");
            for (User u : users) {
                psmt.setString(1,u.getFirstName());
                psmt.setString(2,u.getLastName());
                psmt.setString(3,u.getPassword());
                psmt.setString(4,u.getStreetAddress());
                psmt.setInt(5,u.getAge());
                psmt.setString(6,u.getLogin());
                psmt.addBatch();
            }

            try {
                // Batch is ready, execute it to insert the data
                psmt.executeBatch();
            } catch (SQLException e) {
                System.out.println("Error message: " + e.getMessage());
                return; // Exit if there was an error
            }

            // Commit the transaction to close the COPY command
            con.commit();

        }
        catch (SQLException ex){
            System.out.println(ex.getErrorCode());
            System.out.println("here");
            System.out.println(ex.getMessage());
        }
    }
}
