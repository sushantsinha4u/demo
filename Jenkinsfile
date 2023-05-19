pipeline {
  environment {
    dockerimagename = "springbootpostgresql"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps {
        git 'https://github.com/sushantsinha4u/demo.git'
      }
    }
    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }
    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerhub-credentials'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }
    stage('Deploying springboot container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "E:\SoftwareSetup\Development\k8s\springbootpostgresql.yml", "E:\SoftwareSetup\Development\k8s\postgres.yml")
        }
      }
    }
  }
}