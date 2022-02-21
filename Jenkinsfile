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
				    echo "Step1: LOG4J is ${log4j_version}"
				    
				    String log4j_ver = pom.dependencies[0].version
				    echo "Step2: LOG4J is ${log4j_ver}"
				    
				    def logv = pom.dependencies[0].version
				    echo "Step3: version is " + logv
				    def(int m,int n,int p) = logv.tokenize('.')
				    echo "Major_Version is " + m
				    echo "Minor_Version is " + n
				    echo "Patch_Version is " + p
				    println m.getClass().getName()
				    if (m > 1 && n >= 17){
				    	println ("Step4:log4j version is valid " + logv)
				    }
				    else {
				    	println ("Step5:log version is not valid " + logv)
				    }
				    
				    for (i in pom.dependencies){
					    if ('log4j' in i.groupId){
						    def logver = i.version
						    println ("Step6: version is "+ logver)
						    def (int q, int r, int s) = logver.tokenize('.')
						    println ("Major_Version is " + q)
						    println ("Major_Version is " + r)
						    println ("Major_Version is " + s)
						    if (q > 1 && r >= 17){
							    println ("Step7:log4j version is valid " + logver)
						    	}
				    		    else {
				    			    println ("Step8:log version is not valid "+ logver)
							  }						
					    }
				    }
					   
			    }
		    }
	    }
	
    }
}
