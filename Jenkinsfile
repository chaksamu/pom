pipeline{
    agent any 
    
    stages{
        stage('SCM Checkout') {
            steps{
                git branch: 'main', url: 'https://github.com/chaksamu/pom.git'
		echo "SCM Checkout Success"
            }
        }
    }
}
