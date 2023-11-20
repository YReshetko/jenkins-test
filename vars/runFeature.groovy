def call(){
    def isPullRequestBuild = false
    String version = "1.0.1"
    String requiredVersion = "${env.LOANS_JENKINSFILE_VERSION}"

    def resourceName = (isPullRequestBuild) ? 'loans_pipeline' : ''
    pipeline {
        options {
            lock(label: "${resourceName}", resourceSelectStrategy: 'random',  quantity: 1, variable: "RESOURCE")
        }
        agent any
        stages {
            stage('Check version') {
                steps {
                    script {
                        echo version
                        echo requiredVersion
                        if (!requiredVersion.equals(version)) {
                            error('Обновите версию Jenkinsfile, путем ребэйза бранча с develop')
                        }
                    }
                }
            }
            stage('Hello') {
                when{
                    expression {return isPullRequestBuild}
                }
            
                matrix {
                    axes {
                        axis {
                            name 'job'
                            values '1','2','3'
                        }
                    }
                    stages {
                        stage('Install') {
                            steps {
                                echo env.JENKINS_FILE_VERSION
                                echo 'Start' + env.RESOURCE0_ID
                                sleep 20;
                                echo 'Hello World' + env.RESOURCE0_ID
                                sleep 20;
                                echo 'End' + env.RESOURCE0_ID
                            }
                        }
                    }
                }
            }
            stage('Complete') {
                steps {
                    echo 'Completed'
                }
            }
        }
    }
}