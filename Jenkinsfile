pipeline {
    agent {
        label 'Ubuntu_14'
    }   

    stages {
        stage('Test') {
            steps {
              parallel(
               "Run on chrome browser" : {
                  sh "mvn verify -Dcontext=Chrome verify -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome -Dwebdriver.remote.os=LINUX -Dit.test=LoginTestSuite" 
                },
                "Run on firefox browser" : {
                  sh "mvn verify -Dcontext=Firefox verify -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=firefox -Dwebdriver.remote.os=LINUX -Dit.test=LoginTestSuite" 
                }
                )
               }//steps
        }//stage
        
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
        }    //steps         
      }//stage
    }//stages
}

