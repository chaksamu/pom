pipeline{
    agent any 
    
    stages{
        stage('SCM Checkout') {
            steps{
		cleanWs()    
                git branch: 'main', url: 'https://github.com/chaksamu/pom.git'
		echo "SCM Checkout Success"
            }
        }
	    stage('Read Pom.xml'){
		    steps{
			    script{
			           pom = readMavenPom file: './pom.xml'
				   version = pom.version
				   artifactId = pom.artifactId
                                   groupId = pom.groupId              
                                   echo "version is ${version}"
                                   echo "artifactId is ${artifactId}"
                                   echo "groupId is ${groupId}"
				   log4j_version = pom.dependencies.dependency.version
				    echo "LOG4J is ${log4j_grooupID}"
			    }
		    }
	    }
	
    }
}
