void call() {
    node {
     sh """
     flyway -url=jdbc:snowflake://${SNOWFLAKE_URL} \
            -user=${SNOWFLAKE_USERNAME} \
            -password=${SNOWFLAKE_PASSWORD} \
            -locations=filesystem:migrations \
            migrate
            """
    }
}
