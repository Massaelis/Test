package com.prodius.module3.module3.config;

import org.flywaydb.core.Flyway;

public class FlywayUtil {
    public static void initMigration() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/module3", "postgres", "999267")
                .baselineOnMigrate(true)
                .locations("db/migration/module3")
                .load();
        flyway.migrate();
    }
}
