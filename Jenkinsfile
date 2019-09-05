pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'SlaveTFS'
    }

    //AquÃ­ comienzan los â€œitemsâ€� del Pipeline
    stages{
        stage('Checkout') {
            steps{
                echo "------------>Checkout<------------"
                bat 'java -version'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], gitTool: 'GIT_TFS', submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub_RBarriosG', url: 'https://github.com/RBarriosG/ParqueaderoAndroid']]])
            }
        }

        stage('Build') {
            steps {
                echo "------------>Build<------------"
                bat './gradlew --b ./build.gradle clean build -x :app:test'
            }
        }

        stage('Unit Tests') {
            steps{
                echo "------------>Unit Tests<------------"
                bat ' ./gradlew --b ./build.gradle :app:test'
            }
        }

        stage('Static Code Analysis') {
            steps{
                echo '------------>Análisis de código estático<------------'
                /*withSonarQubeEnv('Sonar') {
                    bat "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"

                }*/
            }
        }
    }

    post {
          always {
              echo 'This will always run'
          }
          success {
              echo 'This will run only if successful'
          }
          failure {
            echo 'This will run only if failed'
            mail (to: 'rodolfo.barrios@ceiba.com.co',
                  subject: "FailedPipeline:${currentBuild.fullDisplayName}",
                  body: "Something is wrongwith ${env.BUILD_URL}")
          }
          unstable {
              echo 'This will run only if the run was marked as unstable'
          }
          changed {
              echo 'This will run only if the state of the Pipeline has changed'
              echo 'For example, if the Pipeline was previously failing but is now successful'
          }
      }
}