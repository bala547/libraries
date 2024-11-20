void call() {
    node {
    def flywayCommand = """
                          ./flyway/flyway \
                          -url='jdbc:snowflake://${SNOWFLAKE_URL}/?warehouse=${SNOWFLAKE_WAREHOUSE}&database=${SNOWFLAKE_DATABASE}&role=${SNOWFLAKE_ROLE}' \ 
                          -user='${SNOWFLAKE_USERNAME}' \
                          -password='${SNOWFLAKE_PASSWORD}' \
                          -schemas=BALA \
                          -table=FLYWAY_SCHEMA_HISTORY \
                          -locations=filesystem:migrations \
                           migrate
                           """
                        sh "${flywayCommand}"
    }
}
