pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Este comando falla a propósito
                sh 'exit 1'
            }
        }
    }
}
