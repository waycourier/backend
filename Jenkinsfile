pipeline {
    agent any
	
    stages {
        stage('Build Application') {
            steps {
                sh 'echo Performing maven build'
            }
        }

 	stage('Package Application') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
