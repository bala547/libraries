def call() {
    node {
        withEnv(["JAVA_TOOL_OPTIONS=--add-opens=java.base/java.nio=ALL-UNNAMED"]) {
            // Run Flyway Docker container with migration
            sh """
                docker run --rm \
                    -v \$(pwd):/flyway/sql \
                    -v \$(pwd)/conf:/flyway/conf \
                    flyway/flyway:10.17.3 migrate
            """
        }
    }
}
