pipeline {
    agent any

    stages {
        stage('Run test') {
            steps {
                withMaven(maven: 'maven_3.6.3') {
                    bat 'clean test allure:report'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
}