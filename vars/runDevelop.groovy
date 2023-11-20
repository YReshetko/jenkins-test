def call(){
    pipeline {
        agent any
        stages {
            stage('Complete') {
                steps {
                    echo 'Completed'
                    script{
                        common()
                    }
                }
            }
        }
    }
}