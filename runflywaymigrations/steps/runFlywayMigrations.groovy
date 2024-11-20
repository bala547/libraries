void call() {
    node {
        // Assuming SNOWFLAKE_URL includes 'https://', use it directly in the JDBC URL
        def flywayUrl = "jdbc:snowflake://${SNOWFLAKE_URL}?warehouse=${SNOWFLAKE_WAREHOUSE}&database=${SNOWFLAKE_DATABASE}&role=${SNOWFLAKE_ROLE}"

        // Construct the Flyway command as a single string without unintended breaks or spaces
        def flywayCommand = "./flyway/flyway -url=${flywayUrl} -user=${SNOWFLAKE_USERNAME} -password=${SNOWFLAKE_PASSWORD} -schemas=BALA -table=FLYWAY_SCHEMA_HISTORY -locations=filesystem:migrations migrate"

        // Print the Flyway command for debugging purposes
        echo "Running Flyway command: ${flywayCommand}"

        // Ensure that the Flyway executable exists and is executable
        sh 'ls -l ./flyway/flyway'  // Check if the Flyway executable exists

        // Run the Flyway migration command as a single string
        sh """${flywayCommand}"""
    }
}
