void call() {
    node {
        // Make sure you have the necessary environment variables for Snowflake
        def snowflakeUrl = "jdbc:snowflake://${SNOWFLAKE_URL}"
        def snowflakeUsername = "${SNOWFLAKE_USERNAME}"
        def snowflakePassword = "${SNOWFLAKE_PASSWORD}"
        def migrationPath = "filesystem:migrations"  // Ensure this path is correct

        // Flyway command string to execute
        def flywayCommand = """
            ./flyway/flyway \
            -url=${snowflakeUrl} \
            -user=${snowflakeUsername} \
            -password=${snowflakePassword} \
            -locations=${migrationPath} \
            migrate
        """

        // Ensure the migration folder and Flyway command are set up correctly
        echo "Running Flyway migrations..."
        
        // Execute the command using 'sh' to run it in the shell
        sh "${flywayCommand}"

        // Optionally, you can add a step to verify if Flyway ran successfully
        // (e.g., checking the migration status)
        sh "./flyway/flyway -url=${snowflakeUrl} -user=${snowflakeUsername} -password=${snowflakePassword} info"
    }
}
