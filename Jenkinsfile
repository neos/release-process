pipeline {
  agent any
  stages {
    stage('Initializing') {
      steps {
        input(message: 'Did you do X?', ok: 'Yes')
        input(message: 'Did you do Y', ok: 'Yes')
      }
    }
    stage('Test stuff') {
      parallel {
        stage('Test stuff') {
          steps {
            waitUntil() {
              sleep 5
            }

          }
        }
        stage('') {
          steps {
            echo 'another test in parallel'
          }
        }
      }
    }
  }
}