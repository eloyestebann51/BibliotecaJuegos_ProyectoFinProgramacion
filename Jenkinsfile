pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Esto falla intencionadamente y fuerza el build a FAILURE
                    sh 'exit 1'
                }
            }
        }
    }
}
