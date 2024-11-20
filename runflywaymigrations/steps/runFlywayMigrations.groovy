void call() {
    node {
    def flywayCommand = """
                          ./flyway/flyway \
                          -url=jdbc:snowflake://${SNOWFLAKE_URL}/?warehouse=${SNOWFLAKE_WAREHOUSE}&database=${SNOWFLAKE_DATABASE}&role=${SNOWFLAKE_ROLE} \
                          -username=${SNOWFLAKE_USERNAME} \
                          -password=${SNOWFLAKE_PASSWORD} \
                          -locations=filesystem:migrations \
                          -schemas=BALA \
                          -table=FLYWAY_SCHEMA_HISTORY \
                           migrate
                           """
                        sh "${flywayCommand}"
    }
}
