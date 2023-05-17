pipeline {
    agent any
    stages {

        stage("Test"){
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
