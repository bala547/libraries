void call() {
    node {
        script {
            // Define environment variables
            def flywayJarPath = '/root/.jenkins/workspace/job2/flyway/lib/flyway/flyway-commandline-10.17.3.jar'
            def snowflakeUrl = '${SNOWFLAKE_URL}'
            def snowflakeUsername = '${SNOWFLAKE_USERNAME}'
            def snowflakePassword = '${SNOWFLAKE_PASSWORD}'

            // Ensure the Flyway JAR exists
            if (!fileExists(flywayJarPath)) {
                error "Flyway JAR not found at ${flywayJarPath}"
            }

            // Run the Flyway migration
            sh """
                java --add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED -jar ${flywayJarPath} \
                -url=jdbc:snowflake://${snowflakeUrl} \
                -user=${snowflakeUsername} \
                -password=${snowflakePassword} \
                -locations=filesystem:migrations migrate
            """
        }
    }
}
