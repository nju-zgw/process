node {
    stage('SCM') {
        git 'https://github.com/nju-zgw/srm.git'
    }
    stage('QA') {
        def sonarHome = '/home/common/sonar-scanner-2.8'
        sh "${sonarHome}/bin/sonar-scanner"
    }
    stage('build') {
        def mvnHome = tool 'M3'
        env.JAVA_HOME = "/usr/java/jdk1.8.0_111/"
        env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
        env.CLASSPATH = "${env.JAVA_HOME}/jre/lib/ext:${env.JAVA_HOME}/lib/tools.jar"
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "service start docker"
        sh "docker stop my || true"
        sh "docker rm my || true"
        sh "docker run --name my -p 11111:8080 -d tomcat"
        sh "docker cp target/srm.war my:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}