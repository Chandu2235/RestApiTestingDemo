pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'Java 17'
    }

    environment {
        BUILD_ENV = 'dev'
        SONAR_TOKEN = credentials('sonar-token-id') // Add this in Jenkins Credentials (as Secret Text)
    }

    stages {
        stage('Run in Docker') {
            steps {
                script {
                    docker.build('test-framework-image').run()
                }
            }
        }

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

        stage('Test Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('My SonarQube Server') {
                    sh "mvn sonar:sonar -Dsonar.login=${SONAR_TOKEN}"
                }
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
            mail to: 'your-email@example.com',
                 subject: "SUCCESS: ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
                 body: "Great news! Build succeeded.\nCheck: ${env.BUILD_URL}"
        }

        failure {
            echo '❌ Build failed!'
            mail to: 'your-email@example.com',
                 subject: "FAILURE: ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
                 body: "Oops! The build failed.\nCheck: ${env.BUILD_URL}"
        }
    }
}
