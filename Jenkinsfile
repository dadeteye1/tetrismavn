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
                sh 'cd tetris-game-master && mvn clean package'
            }
        }
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.war', allowEmptyArchive: false
            }
        }
        stage('Test') {
            steps {
                sh 'cd tetris-game-master && mvn test'
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat9', path: '', url: 'http://3.141.19.143:8080/')], 
                       contextPath: '/webapp', 
                       war: '**/target/*.war'
            }
        }
    }
}
