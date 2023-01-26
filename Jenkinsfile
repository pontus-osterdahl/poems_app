pipeline {
    agent any
    stages {
        stage("Build"){
            steps {
                dir("poems_app"){
                    sh "mvn spring-boot:run"
                }
            }
        }
    }
}
