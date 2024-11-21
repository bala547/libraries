void call() {
    node {
        sh """
        java --add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED \
             -jar flyway-commandline-10.17.3.jar \
             -url=jdbc:snowflake://${SNOWFLAKE_URL} \
             -user=${SNOWFLAKE_USERNAME} \
             -password=${SNOWFLAKE_PASSWORD} \
             -locations=filesystem:migrations \
             migrate
        """
    }
}
