package com.prodius.module3.lesson26hw.config;

import org.flywaydb.core.Flyway;

public class FlywayUtil {
    public static void initMigration() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/test2", "postgres", "999267")
                .baselineOnMigrate(true)
                .locations("db/migration/lesson26hw")
                .load();
        flyway.migrate();
    }
}
