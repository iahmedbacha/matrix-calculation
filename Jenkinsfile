pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle generateMatrixAPI test'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'Mail notification', body: 'This is a mail notification', cc: 'fm_khodja@esi.dz')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            withSonarQubeEnv('Préparation') {
              bat 'sonar-scanner'
            }

          }
        }
        stage('Test Reporting') {
          steps {
            jacoco()
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        sh 'gradle uploadArchives'
      }
    }
  }
}