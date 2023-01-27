pipeline {
    agent any
    stages {
        stage("Build"){
            steps {
                    sh "mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085"
            }
        }
    }
}
