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
				    
				    major_version = pom.dependencies[0].version.split('.')[0] as Integer
				    minor_version = pom.dependencies[0].version.split('.')[1] as Integer
				    patch_version = pom.dependencies[0].version.split('.')[2] as Integer
				    
				    echo "Major_Version is ${major_version}"
				    echo "Minor_Version is ${minor_version}"
				    echo "Patch_Version is ${patch_version}"
			    }
		    }
	    }
	
    }
}
