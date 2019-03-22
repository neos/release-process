pipeline {
  agent any
  stages {
    stage('Initializing') {
      parallel {
        stage('Initializing') {
          steps {
            input(message: 'Did you do X?', ok: 'Yes')
            input(message: 'Did you do Y', ok: 'Yes')
          }
        }
        stage('misc') {
          agent any
          steps {
            sh 'echo "hello world"; echo "lala";'
            retry(count: 5) {
              echo 'dummy'
            }

            emailext(subject: 'subject', body: 'body', from: 'jenkins@neos.io', replyTo: 'noreply@neos.io', to: 'current-rm@neos.io')
            build(job: 'flow-create-branch', wait: true)
          }
        }
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
        stage('error') {
          steps {
            echo 'another test in parallel'
          }
        }
      }
    }
  }
}