pipeline {
    agent any
    stages {
        stage("Build"){
            steps {
                    sh "mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8090'"
            }
        }
    }
}
