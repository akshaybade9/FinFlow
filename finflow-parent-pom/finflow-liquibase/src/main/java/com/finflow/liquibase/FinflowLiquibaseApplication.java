package com.finflow.liquibase;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.database.jvm.JdbcConnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class FinflowLiquibaseApplication {  // <- Must be public
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/finflow_db";
        String username = "root";
        String password = "Akshay@754";
        String changelogFile = "db/changelog/db.changelog-master.xml";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase(changelogFile, new ClassLoaderResourceAccessor(), database);
            liquibase.update("");
        }

        System.out.println("Liquibase migration completed!");
    }
}