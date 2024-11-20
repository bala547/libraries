void call() {
    node {
        // Define the Flyway command properly
        def flywayCommand = """
                              ./flyway/flyway \
                              -url=jdbc:snowflake://${SNOWFLAKE_URL} \
                              -user=${SNOWFLAKE_USERNAME} \
                              -password=${SNOWFLAKE_PASSWORD} \
                              -locations=filesystem:migrations \
                              migrate
                             """
        // Execute the Flyway migration command
        sh "${flywayCommand}"
    }
}
