pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Comando de construcción real, ejemplo npm
                sh 'npm install'
                sh 'npm run build'
            }
        }
    }
}
