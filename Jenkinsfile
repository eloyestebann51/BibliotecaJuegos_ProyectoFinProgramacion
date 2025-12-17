pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                // Ejecuta el test en Bash
                sh 'bash test.sh'
            }
            post {
                always {
                    // Publica los resultados de test en Jenkins
                    junit 'test-results/results.xml'
                }
            }
        }

        stage('Build') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo "Compilando la aplicación..."
                // Aquí iría tu comando de build real si lo tienes
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo "Desplegando la aplicación..."
                // Aquí iría tu comando de deploy real
            }
        }
    }

    post {
        failure {
            echo "El pipeline ha fallado. Revisa la etapa Test en Jenkins."
        }
        success {
            echo "Pipeline completado correctamente."
        }
    }
}
