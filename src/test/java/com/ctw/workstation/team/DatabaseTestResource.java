/*
package com.ctw.workstation.team;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

@QuarkusTest
public class DatabaseTestResource implements QuarkusTestResourceLifecycleManager {

    PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest");

    @Override
    public Map<String, String> start() {
        postgreSQLContainer.withUsername("postgres").withPassword("postgres").withDatabaseName("fs_academy").start();
        return Map.of();
    }


    @Override
    public void stop() {
        postgreSQLContainer.stop();
    }


}
*/
