pipeline {
    agent any
    parameters {
      string defaultValue: 'testng.xml', name: 'xml_file'
    }
    stages {
        stage('Run Tests') {
            steps {
                script {
                    def xmlFile = params.xml_file
                    sh "mvn clean test -DsuiteFile=${xmlFile}"
                }
            }
        }
    }
    post {
      always {
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }
}
