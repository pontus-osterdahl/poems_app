pipeline {
    agent any
    stages {
          stage("test"){
            steps {
                    sh "mvn test"
            }
        }
        stage("Build"){
            steps {
                    sh "mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8090'"
            }
        }
    }
}
