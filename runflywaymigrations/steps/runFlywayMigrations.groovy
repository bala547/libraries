void call() {
    node {
        // Construct the Flyway command as a single line
        def flywayCommand = "./flyway/flyway -url=jdbc:snowflake://${SNOWFLAKE_URL}?warehouse=${SNOWFLAKE_WAREHOUSE}&database=${SNOWFLAKE_DATABASE}&role=${SNOWFLAKE_ROLE} -user=${SNOWFLAKE_USERNAME} -password=${SNOWFLAKE_PASSWORD} -schemas=BALA -table=FLYWAY_SCHEMA_HISTORY -locations=filesystem:migrations migrate"
        
        // Print the Flyway command for debugging purposes
        echo "Running Flyway command: ${flywayCommand}"
        
        // Ensure that the command is executable and present in the correct path
        sh 'ls -l ./flyway/flyway'  // Check if the Flyway executable exists
        
        // Run the Flyway migration command
        sh "${flywayCommand}"
    }
}
