void call() {
    node {
        def flywayImage = 'flyway/flyway:10.17.3' // Specific Flyway image version to avoid potential issues

        echo "Running Flyway Migrations..."

        // Ensure the necessary environment variable is set before running Flyway migration
        withEnv(["JAVA_TOOL_OPTIONS=--add-opens=java.base/java.nio=ALL-UNNAMED"]) {
            
            // Log the environment variable for debugging purposes
            echo "JAVA_TOOL_OPTIONS=${env.JAVA_TOOL_OPTIONS}"

            // Use the correct escaping and ensure variables are correctly passed to Docker command
            sh """
                docker run --rm \\
                    -v \$(pwd)/migrations:/flyway/sql \\
                    ${flywayImage} \\
                    -url=jdbc:snowflake://${SNOWFLAKE_URL} \\
                    -user=${SNOWFLAKE_USERNAME} \\
                    -password=${SNOWFLAKE_PASSWORD} \\
                    -locations=filesystem:/flyway/sql \\
                    migrate
            """
        }
    }
}
