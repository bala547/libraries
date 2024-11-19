def call() {
    node {
        // Set the JVM options required for Flyway and Snowflake JDBC
        withEnv(["JAVA_TOOL_OPTIONS=--add-opens=java.base/java.nio=ALL-UNNAMED"]) {
            // Your Flyway logic here (e.g., downloading Flyway, running migrations)
            sh "wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/${FLYWAY_VERSION}/flyway-commandline-${FLYWAY_VERSION}-linux-x64.tar.gz"
            sh "tar xzvf flyway-commandline-${FLYWAY_VERSION}-linux-x64.tar.gz"
            sh "mv flyway-${FLYWAY_VERSION} flyway"
            sh "rm flyway-commandline-${FLYWAY_VERSION}-linux-x64.tar.gz"
            sh "./flyway/bin/flyway migrate"
        }
    }
}
