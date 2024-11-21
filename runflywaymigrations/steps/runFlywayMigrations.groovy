void call() {
    node {
        sh """
        docker run --rm \
            -v \$(pwd)/migrations:/flyway/sql \
            -v \$(pwd)/flyway.conf:/flyway/conf/flyway.conf \
            flyway/flyway:latest \
            -url=jdbc:snowflake://${SNOWFLAKE_URL} \
            -user=${SNOWFLAKE_USERNAME} \
            -password=${SNOWFLAKE_PASSWORD} \
            -locations=filesystem:/flyway/sql \
            migrate
        """
    }
}
