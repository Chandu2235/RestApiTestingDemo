pipeline {
    agent any  // Run on any available agent

    tools {
        maven 'Maven 3'        // Name from Global Tool Configuration
        jdk 'Java 17'          // Name from Global Tool Configuration
    }

    environment {
        // Example env variable
        BUILD_ENV = 'dev'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Chandu2235/your-repo.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
