pipeline{
    agent any
    tools{
        maven 'maven_3.8.7'
    }
    stages{
        stage('Build Maven Project'){
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'git branch: \'main\', url: \'https://github.com/SlyCreator/Spring-Quiz-App.git\'']]])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker image'){
            steps{
                sh 'docker build -t slycreator/quiz-app .'
            }
        }

        stage('Push to Container Registry'){
            steps{
                script {
                    withCredentials([gitUsernamePassword(credentialsId: '', gitToolName: 'Default'), string(credentialsId: 'dockerpwd', variable: 'dockerpwd')]) {
                        sh 'docker login -u slycreator -p ${dockerpwd}'
                    }
                    sh 'docker push slycreator/quiz-app'
                }
            }
        }
    }
}