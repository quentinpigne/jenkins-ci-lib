#!/usr/bin/env groovy
import fr.quentinpigne.jenkins.Constants

def call(params) {
    pipeline {
        stages {
            stage('Checkout') {
                steps {
                }
            }

            stage('Compile') {
                steps {
                }
            }

            stages {
                stage('Linter') {
                    steps {
                    }
                }

                stage('Test') {
                    steps {
                    }
                }
            }

            stage('Package') {
                steps {
                }
            }

            stage('Deliver / Publish') {
                steps {
                }
            }

            stage('Deploy') {
                steps {
                }
            }
        }

        post {
            success {
                script {
                    for (successStep in params.successSteps) {
                        successStep()
                    }
                }
            }
        }
    }
}
