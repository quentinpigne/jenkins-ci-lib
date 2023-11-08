#!/usr/bin/env groovy
import fr.quentinpigne.jenkins.Constants

def call(params, builder) {
    pipeline {
        stages {
            stage('Checkout') {
                steps {
                }
            }

            stage('Compile') {
                steps {
                    script {
                        builder.compile(params)
                    }
                }
            }

            stages {
                stage('Linter') {
                    steps {
                        script {
                            builder.lint(params)
                        }
                    }
                }

                stage('Test') {
                    steps {
                        script {
                            builder.test(params)
                        }
                    }
                }
            }

            stage('Package') {
                steps {
                    script {
                        builder.package(params)
                    }
                }
            }

            stage('Deliver / Publish') {
                steps {
                    script {
                        builder.publish(params)
                    }
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
