void call() {
    node {
    def flywayCommand = """
                          ./flyway/flyway \
                          -url=jdbc:snowflake://${SNOWFLAKE_URL} \
                          -username=${SNOWFLAKE_USERNAME} \
                          -password=${SNOWFLAKE_PASSWORD} \
                          -role=${SNOWFLAKE_ROLE} \
                          -warehouse=${SNOWFLAKE_WAREHOUSE} \
                          -database=${SNOWFLAKE_DATABASE} \
                          -locations=filesystem:migrations \
                          -schemas=BALA \
                          -table=FLYWAY_SCHEMA_HISTORY \
                           migrate
                           """
                        sh "${flywayCommand}"
    }
}
