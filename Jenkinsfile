pipeline {
    agent any // Define dónde se ejecuta (puedes usar un contenedor si prefieres)

    stages {
        stage('Checkout') {
            steps {
                // Descarga el código del repositorio
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Instalando dependencias y construyendo...'
                // Ejecutamos los comandos reales
                sh 'npm install'
                sh 'npm run build'
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Esto hace que el artefacto sea visible en la interfaz de Jenkins
                // Ajusta la ruta según tu carpeta de salida (dist, build, target, etc.)
                archiveArtifacts artifacts: 'dist/**', fingerprint: true
            }
        }
    }
    
    post {
        always {
            echo 'Limpiando el espacio de trabajo...'
            // Opcional: acciones tras finalizar el build
        }
    }
}
