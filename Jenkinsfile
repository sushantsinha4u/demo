pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sushantsinha4u/demo']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build ./ -t springbootpostgresql'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'Sushant@1084', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u 0906 -p ${dockerhubpwd}'

}
                   sh 'docker push javatechie/devops-integration'
                }
            }
        }
    }
}