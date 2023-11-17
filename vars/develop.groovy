def run(){
    pipeline {
        agent any
        stages {
            stage('Complete') {
                steps {
                    echo 'Completed'
                }
            }
        }
    }
}
