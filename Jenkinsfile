pipeline {
    agent any
    stages {
        stage("Build"){
            steps {
                    sh "mvn spring-boot:run -Drun.arguments=--server.port=8085"
            }
        }
    }
}
