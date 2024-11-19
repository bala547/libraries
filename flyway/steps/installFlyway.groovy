def call() {
    node {
        // Set the JVM options required for Flyway and Snowflake JDBC
        withEnv(["JAVA_TOOL_OPTIONS=--add-opens=java.base/java.nio=ALL-UNNAMED"]) {
            // Your Flyway logic here (e.g., downloading Flyway, running migrations)
            sh "wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/10.17.3/flyway-commandline-10.17.3-linux-x64.tar.gz"
            sh "tar xzvf flyway-commandline-10.17.3-linux-x64.tar.gz"
            sh "mv flyway-10.17.3 flyway"
            sh "rm flyway-commandline-10.17.3-linux-x64.tar.gz"
            sh "./flyway/bin/flyway migrate"
        }
    }
}
