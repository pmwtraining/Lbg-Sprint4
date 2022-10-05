pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                sh '''
                docker build -t java-app:latest .
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                docker run -p 80:8080 --name java-appy java-app:latest
                '''
            }
        }
    }
}