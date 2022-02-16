pipeline{
    agent any 
    
    stages{
        stage('SCM Checkout') {
            steps{
                git branch: 'main', url: 'https://github.com/chaksamu/pom.git'
                pom = readMavenPom file: './pom.xml'
				        version = pom.version
				        artifactId = pom.artifactId
                groupId = pom.groupId
              
              echo "version is ${version}"
              echo "artifactId is ${artifactId}"
              echo "groupId is ${groupId}"
            }
        }
    }
}
