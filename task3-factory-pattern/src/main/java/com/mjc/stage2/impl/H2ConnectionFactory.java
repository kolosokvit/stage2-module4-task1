package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        try {
           Properties properties = new Properties();
           properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("h2database.properties"));
           String driver = properties.getProperty("jdbc_driver");
           String url = properties.getProperty("db_url");
           String user = properties.getProperty("user");
           String password = properties.getProperty("password");
           return DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

