void call() {
    sh "rm -rf flyway"
    sh "wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/${FLYWAY_VERSION}/flyway-commandline-${FLYWAY_VERSION}-linux-x64.tar.gz"  
    sh "tar xzvf flyway-commandline-${FLYWAY_VERSION}-linux-x64.tar.gz"
    sh "mv flyway-${FLYWAY_VERSION} flyway"
    sh "rm flyway-commandline-${FLYWAY_VERSION}-linux-x64.tar.gz"
}