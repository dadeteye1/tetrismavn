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
                sh 'cd tetris && mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'cd tetris && mvn test'
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat9', path: '', url: 'http://18.188.105.217:8080//')], contextPath: '/webapp', war: '**/*.war'
            }
        }
    }
}
