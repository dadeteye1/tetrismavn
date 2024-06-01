pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/dadeteye1/tetrismavn.git'
            }
        }
        stage('Build') {
            steps {
                dir('tetris') {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir('tetris') {
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat9', path: '', url: 'http://18.188.105.217:8080')], contextPath: '/tetris', war: '**/target/*.war'
            }
        }
    }
    
    post {
        success {
            echo 'Build, test, and deployment successful'
        }
        failure {
            echo 'Build, test, or deployment failed'
        }
    }
}
