pipeline {
    agent any
    stages {
        stage('Build') {   // El nombre puede ser cualquiera, pero debe ser único
            steps {
                sh 'npm install'
                sh 'npm run build'
            }
        }
        stage('Test') {    // Opcional, ejemplo de segunda etapa
            steps {
                sh 'npm test'
            }
        }
    }
}
