pipeline {
    agent any
    stages {
          stage("Build"){
            steps {
                    sh "mvn compile"
            }
        }
        stage("Build"){
            steps {
                    sh "mvn test"
            }
        }
    }
}
