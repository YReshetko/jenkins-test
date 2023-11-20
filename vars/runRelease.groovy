def call(){
     pipeline {
        agent any
        stages {
            stage('Release') {
                steps {
                    echo 'Relese'
                }
            }
        }
    }
}