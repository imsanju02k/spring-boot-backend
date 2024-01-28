pipeline{
    agent any
    stages{

        stage('Git checkout'){
            steps{
                gitcheckout(
                    branch:"main",
                    url:"https://github.com/imsanju02k/spring-boot-backend.git"
                )
            }
        }
    }
}