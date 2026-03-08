package com.finflow.liquibase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LiquibaseStartup implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    	FinflowLiquibaseApplication.main(args);
    }
}