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


        
    }
}
