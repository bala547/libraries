void call() {
    node {
        // Construct the Flyway command
        def flywayCommand = "./flyway/flyway -url=jdbc:snowflake://${SNOWFLAKE_URL}?warehouse=${SNOWFLAKE_WAREHOUSE}&database=${SNOWFLAKE_DATABASE}&role=${SNOWFLAKE_ROLE} -user=${SNOWFLAKE_USERNAME} -password=${SNOWFLAKE_PASSWORD} -schemas=BALA -table=FLYWAY_SCHEMA_HISTORY -locations=filesystem:migrations migrate"
        
        // Print the command for debugging purposes
        echo "Running Flyway command: ${flywayCommand}"

        // Execute the Flyway command
        sh "${flywayCommand}"
    }
}
