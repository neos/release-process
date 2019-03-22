pipeline {
  agent any
  stages {
    stage('Initializing') {
      steps {
        input(message: 'Did you inititate login screen photo voting?', ok: 'Yes')
        input(message: 'Did you determine the release name?', ok: 'Yes')
        input(message: 'Did you initiate the feature freeze?', ok: 'Yes')
        input(message: 'Did you announce the feature freeze?', ok: 'Yes')
      }
    }
    stage('Branching') {
      steps {
        // These are to be transformed into tests and run in parallel
        input(message: 'Branch was created', ok: 'Yes')
        input(message: 'Branch can be required as *-dev', ok: 'Yes')
        input(message: '.travis.yml was updated', ok: 'Yes')
        input(message: 'FLOW_VERSION_BRANCH was updated', ok: 'Yes')
        input(message: '.apigen.yml was updated', ok: 'Yes')
        input(message: 'conf.py (documentation) was updated', ok: 'Yes')
        input(message: 'index.html on neos.github.io was updated', ok: 'Yes')
        input(message: 'Collection manifest is consistent with sub-package requirements', ok: 'Yes')
      }
    }
    stage('Stabilization') {
      steps {
        input(message: 'Branch build is green on Travis CI', ok: 'Yes')
        input(message: 'Build job for assets (JS/CSS) has finished', ok: 'Yes')
        input(message: 'Upmerges have been done', ok: 'Yes')
      }
    }
    stage('Documentation') {
      steps {
        input(message: 'Documentation has been updated', ok: 'Yes')
      }
    }
    stage('Release') {
      steps {
        input(message: 'Flow release was triggered', ok: 'Yes')
        input(message: 'Neos release was triggered', ok: 'Yes')
      }
    }
    stage('Smoke Testing') {
      steps {
        input(message: 'Released version can be installed', ok: 'Yes')
        input(message: 'Important packages can be installed', ok: 'Yes')
        input(message: 'Changelog is visible on neos.readthedocs.io', ok: 'Yes')
        input(message: 'Release build is green', ok: 'Yes')
        input(message: 'Documentation is visible on neos.readthedocs.io', ok: 'Yes')
        input(message: 'Split jobs are done', ok: 'Yes')
      }
    }
    stage('Externals') {
      steps {
        input(message: 'Relevant organizations have been notified about the new release', ok: 'Yes')
      }
    }
    stage('Neos.io housekeeping') {
      steps {
        input(message: 'Neos website has been updated for release', ok: 'Yes')
      }
    }
    stage('Announcements') {
      steps {
        input(message: 'Release has been announced', ok: 'Yes')
      }
    }
    stage('Finalization') {
      steps {
        input(message: 'Project board has been closed', ok: 'Yes')
        input(message: 'Newsletter has been sent', ok: 'Yes')
        input(message: 'Wikipedia has been updated', ok: 'Yes')
      }
    }
  }
}
