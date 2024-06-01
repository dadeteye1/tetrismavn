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
                sh 'cd tetris-master-game && mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'cd tetris-master-game && mvn test'
            }
        }
        stage('Deploy to Tomcat') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat9', path: '', url: 'http://3.141.19.143:8080//')], contextPath: '/app', war: '**/*.war'
            }
        }
    }
}
