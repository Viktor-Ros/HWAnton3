pipeline {
    agent any
     
    stages {
        stage('Run test') {
            steps {
                withMaven(jdk: 'JDK_Def', maven: 'Maven') {
                    bat 'mvn "'${PARAM}'"'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, 
                jdk: 'JDK_Def', 
                report: 'target/allure-report', 
                results: [[path: 'target/allure-results']]
            }
        }
    }
}