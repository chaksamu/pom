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
				   log4j_version = pom.dependencies[0].version
				    echo "LOG4J is ${log4j_version}"
				    
				   Major_Version = log4j_version.split('.')[0]
				   Minor_Version = log4j_version.split('.')[1]
				   Patch_Version = log4j_version.split('.')[2]
				    
				    echo "Major_Version is ${Major_Version}"
				    echo "Minor_Version is ${Minor_Version}"
				    echo "Patch_Version is ${Patch_Version}"
			    }
		    }
	    }
	
    }
}
