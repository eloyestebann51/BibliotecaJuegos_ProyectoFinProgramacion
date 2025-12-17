pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Ejecuta un comando que falle intencionadamente
                sh(script: 'exit 1', returnStatus: false)
            }
        }
    }
}
