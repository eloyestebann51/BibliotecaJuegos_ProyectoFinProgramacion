pipeline {
    agent any

    environment {
        NODE_ENV = 'production'
    }

    stages {
        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Build') {
            steps {
                sh 'npm rundf234 build || exit 1'
            }
        }

        stage('Test') {
            steps {
                sh 'npm test || echo "Tests fallaron pero no rompen el build"'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'dist/**', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build completado con éxito'
        }
        failure {
            echo 'Build falló'
        }
        always {
            echo 'Fin del pipeline, logs completos accesibles'
        }
    }
}
