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
                docker run -p 8080:8080 --name java-app java-app:latest
                '''
            }
        }
    }
}