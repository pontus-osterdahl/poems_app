pipeline {
    agent any
    stages {
        stage("Build"){
            steps {
                dir("poems_app"){
                    sh "./mvnw spring-boot:run"
                }
            }
        }
    }
}
