import com.cloudbees.groovy.cps.NonCPS
import groovy.io.FileType

def FindLog4jversion(i) {
    if (i.groupId.contains('log4j')) {
        def logver = i.version
        println ('Version is ' + logver)
        def (int q, int r, int s) = logver.tokenize('.')
        println ('Major_Version is ' + q + ' , ' + 'Minor_Version is ' + r + ' , ' + 'Patch_Version is ' + s)
        if (q == 1 ) {
            println 'Log4j Version is configured with lower exception. Please upgrade the log4j version' + logver
        }
            else if (q >= 2 && r >= 17) {
            println ('Log4j version is valid ' + logver)
            }
        else {
            println ('Log4j version is not valid ' + logver)
            error 'Please modify the log4j version as per guidelines'
        }
    }
}

def Findinsidelo4jver(filepath){
def cDir = new File(filepath)
cDir.eachFileRecurse(FileType.FILES) { file ->
if (file.name =~ /.*\.jar$/) {
println(file)
def jarContents = "jar tvf ${file}".execute().text;
jarContents.eachLine { line -> //println(line)
if (line.contains('log4j') && line.contains('jar')) {
//println(line)
line = line-(".jar")
//println(line)
def logver = line.split("-")[-1]
println (logver)
def (int q,int r,int s) = logver.tokenize('.') as Integer[]
println ('Major_Version is ' + q + ' , ' + 'Minor_Version is ' + r + ' , ' + 'Patch_Version is ' + s )
checkversion(q,r,s)



}
}
}
}
}

pipeline {
    agent any
    stages {
        stage('SCM Checkout') {
            steps {
                //cleanWs()
                git branch: 'main', url: 'https://github.com/chaksamu/pom.git'
                echo 'SCM Checkout Success'
            }
        }
        stage('Read Pom.xml') {
            steps {
                script {
                    pom = readMavenPom file: './pom.xml'
                    version = pom.version
                    artifactId = pom.artifactId
                    groupId = pom.groupId
                    for (i in pom.dependencies) {
                        println(i)
                        FindLog4jversion(i)
                    }
                    for (j in pom.dependencyManagement) {
                        println(j)
                        for (k in j.dependencies) {
                            println(k)
                            FindLog4jversion(k)
                        }
                    }           
                    Findinsidelo4jver("./src/com/syniverse/devops/target")
                    }
                }
            }
        }
    }
