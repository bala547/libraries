void call() {
    node {
        def flywayImage = 'flyway/flyway:10.17.3' 

        echo "Running Flyway Migrations..."

        withEnv(["JAVA_TOOL_OPTIONS=--add-opens=java.base/java.nio=ALL-UNNAMED"]) {
            sh """
                docker run --rm \
                    -v \$(pwd)/migrations:/flyway/sql \
                    ${flywayImage} \
                    -url=jdbc:snowflake://${SNOWFLAKE_URL} \
                    -user=${SNOWFLAKE_USERNAME} \
                    -password=${SNOWFLAKE_PASSWORD} \
                    -locations=filesystem:/flyway/sql \
                    migrate
            """
        }
    }
}
