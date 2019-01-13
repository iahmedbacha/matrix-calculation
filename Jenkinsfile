pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle generateMatrixAPI --stacktrace'
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
            waitForQualityGate true
          }
        }
        stage('Test Reporting') {
          steps {
            sh 'gradle test'
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