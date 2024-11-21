def call() {
    node {
             withEnv(["JAVA_TOOL_OPTIONS=--add-opens=java.base/java.nio=ALL-UNNAMED"]){
             sh "rm -rf flyway"
             sh "wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/10.17.3/flyway-commandline-10.17.3-linux-x64.tar.gz"  
             sh "tar xzvf flyway-commandline-10.17.3-linux-x64.tar.gz"
             sh "mv flyway-10.17.3 flyway"
             sh "rm flyway-commandline-10.17.3-linux-x64.tar.gz"
 }
    }
}
