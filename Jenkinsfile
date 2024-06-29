pipeline {
    agent { docker { image 'maven:3.9.8-eclipse-temurin-21-alpine' } }
    stages {
        stage('Build Application') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
