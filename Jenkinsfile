#!groovy
node('ci-docker') {

  stage 'Pull eXo Docker Image'
  def eXoJDKMaven = docker.image('exoplatform/ci:jdk8-maven32');
  eXoJDKMaven.pull()

  stage 'Checkout SCM'
  checkout scm

  stage 'Build'

  try {
      // Use custom settings.xml file on project workspace directory
       wrap([$class: 'ConfigFileBuildWrapper', managedFiles: [[fileId: 'exo-ci-maven-settings', targetLocation: 'settings.xml', variable: '']]]) {
         eXoJDKMaven.inside() {
           sh 'mvn install -s settings.xml'
           step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])
           step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
         }
       }
  } finally {
       //clean local copy
       sh 'rm -f settings.xml'
  }


}
