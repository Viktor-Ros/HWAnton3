pipeline {
    agent any

    stages {
        stage('getParam') {
            steps {
                echo '${PARAM}'
                }
            }
        }
        
    stages {
        stage('Build') {
            steps {
                withMaven(jdk: 'JDK_Def', maven: 'Maven') {
                    bat 'mvn ${PARAM}'
                }
            }
        }
        stage('Allure Report') {
            steps {
                allure includeProperties: false, 
                jdk: 'JDK_Def', 
                report: 'target/allure-report', 
                results: [[path: 'target/allure-results']]
            }
        }
    }
}