pipeline {
    agent any
     stages{
        stage('Build') {
            steps {
                withMaven(jdk: 'JDK_Def', maven: 'Maven') {
                bat "mvn clean -Dtest=${params.MAVEN} test" 
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