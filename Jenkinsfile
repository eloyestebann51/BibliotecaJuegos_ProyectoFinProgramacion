pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Instalando dependencias...'
                sh 'npm install'
                
                echo 'Construyendo la aplicación...'
                sh 'npm run build'
            }
        }

        stage('Archive') {
            steps {
                echo 'Archivando artefactos...'
                archiveArtifacts artifacts: 'dist/**', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build completado con éxito ✅'
        }
        failure {
            echo 'Build falló ❌'
        }
    }
}

