pipeline {
    agent {
        label 'master'
    }   

    stages {
        stage('Test') {
            steps {
                sh "mvn verify -Dcontext=Firefox -Dwebdriver.driver=firefox -Dit.test=LoginTestSuite" 
            }
        }
        
        stage("report aggregation") {
          steps {
          // publish the Serenity report
          publishHTML(target: [
                reportName : 'Serenity',
                reportDir:   'target/site/serenity',
                reportFiles: 'index.html',
                keepAll:     true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
        ])
      }             
      }
    }
}
