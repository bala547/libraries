void call() {
    def flywayCommand = """
                          ./flyway/flyway \
                          -url=jdbc:snowflake://${SNOWFLAKE_URL} \
                          -user=${SNOWFLAKE_USERNAME} \
                          -password=${SNOWFLAKE_PASSWORD} \
                          -locations=filesystem:migrations \
                          -schemas=BALA \
                           migrate
                           """
                        sh "${flywayCommand}"
}
