int BATCH_COUNT = 8
int FORK_COUNT = 8
def serenityBatches = [:]

for (int i = 1; i <= BATCH_COUNT; i++) {
    def batchNumber = i
    def batchName = "batch-${batchNumber}"

    serenityBatches[batchName] = {
        node {
            checkout scm
            try {
                mvn "clean"
                sh "rm -rf target/site/serenity"
                mvn "verify -Dit.test=DefinitionTestSuite -Dparallel.tests=FORK_COUNT -Dserenity.batch.count=${BATCH_COUNT} -Dserenity.batch.number=${batchNumber} -Dserenity.test.statistics.dir=/statistics -f businessAcceptanceTests/pom.xml"
            } catch (Throwable e) {
                throw e
            } finally {
                stash name: batchName,
                    includes: "target/site/serenity/**/*",
                    allowEmpty: true
            }
        }
    }
}

stage("automated tests") {
    parallel serenityBatches
}

stage("report aggregation") {
    node {
        // unstash each of the batches

        for (batchNumber in BATCH_COUNT) {
            def batchName = "batch-${batchNumber}"
            echo "Unstashing serenity reports for ${batchName}"
            unstash batchName
        }

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