def FindLog4jversion(i){
	if (i.groupId.contains('log4j')){
		def logver = i.version
		println ("Version is "+ logver)
		def (int q, int r, int s) = logver.tokenize('.')
		println ("Major_Version is " + q + " , " + "Minor_Version is " + r + " , " + "Patch_Version is " + s)
    		if (q == 1 ){
     			println "Log4j Version is configured with lower exception. Please upgrade the log4j version" + logver
    		}
    		else if (q >= 2 && r >= 17){
			println ("Log4j version is valid " + logver)
		}		
		else {
			println ("Log4j version is not valid "+ logver)
			error "Please modify the log4j version as per guidelines"
		} 
	}
}
def FindLog4jVersionInsideJar(){
	def cDir = new File(".");
	def jarContents;
	cDir.eachFileRecurse{file ->
  		if (file.name =~ /.*\.jar$/)
  		{
			jarContents = "jar tvf ${file}".execute().text;
    			jarContents.eachLine{line ->
      			if (line.contains(args[0])){
        			print "*** found in ${file.canonicalPath}:";
			        println line;
      			}
    		}
  	}
    }
}	


pipeline{
    agent any
    stages{
        stage('SCM Checkout'){
           steps{
               cleanWs()
               git branch: 'main', url: 'https://github.com/chaksamu/pom.git'
               echo "SCM Checkout Success"
           } 
        }
        stage('Read Pom.xml'){
            steps{
                script {
                   pom = readMavenPom file: './pom.xml'
                  version = pom.version
                  artifactId = pom.artifactId
                 groupId = pom.groupId
                 for (i in pom.dependencies){
                     println(i)
                     FindLog4jversion(i)
                 }
                    for (j in pom.dependencyManagement){
                        println(j)
                        for (k in j.dependencies) {
                            println(k)
                          FindLog4jversion(k)
                        }
                    }
			FindLog4jVersionInsideJar()
                }
            }
        }
    }
}
