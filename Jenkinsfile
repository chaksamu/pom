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
				    
				    String log4j_ver = pom.dependencies[0].version
				    echo "LOG4J is ${log4j_ver}"
				    
				    def logv = pom.dependencies[0].version
				    echo "version is " + logv
				    def m = logv.split('.')[0]
				    def n = logv.split('.')[1]
				    def p = logv.split('.')[2]
				    echo "Major_Version is " + m
				    echo "Minor_Version is " + n
				    echo "Patch_Version is " + p
			    }
		    }
	    }
	
    }
}
