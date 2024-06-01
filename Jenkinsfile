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
        stage('Deploy to Tomcat') {
            steps {
                script {
                    def tomcatUrl = 'http://3.141.19.143:8080/manager/text'
                    def warFile = 'tetris/target/tetris-game-1.0-SNAPSHOT.war'
                    def contextPath = '/tetris'
                    
                    withCredentials([usernamePassword(credentialsId: 'tomcat9', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh """
                            curl -u ${USERNAME}:${PASSWORD} --upload-file ${warFile} ${tomcatUrl}/deploy?path=${contextPath}&update=true
                        """
                    }
                }
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
