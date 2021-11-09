pipeline {
agent any
stages {
stage ('GIT') {
steps {
echo "Getting Project from Git";
git "https://github.com/solmi12/TimesheetProject-.git";
}
}
stage ('MVN CLEAN') {
steps {
echo "Maven Clean";
bat 'mvn clean';
}
}
stage ('MVN PACKAGE') {
steps {
echo "Maven Package";
bat 'mvn package';
}
}
stage ('MVN INSTALL') {
steps {
echo "Maven Install";
bat 'mvn install';
}
}
stage ('MVN TEST') {
steps {
echo "Maven Test JUnit";
bat 'mvn test';
}
}
stage ('MVN SONAR') {
steps {
echo "Maven Sonar";
bat 'mvn sonar:sonar';
}
}
stage ('MVN DEPLOY') {
steps {
echo "Maven Deploy";
bat 'mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.0.jar';
}
}
}
post {
        always {
            emailext body: 'Pipeline started Building , You will receive an email containing build state', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Building'
        }
        success {  
             emailext body: 'Pipeline success', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Success'  
         }  
         failure {  
             emailext body: 'Pipeline failed', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Failed' 
         }  
         unstable {  
             emailext body: 'Pipeline unstable', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Unstable' 
         } 

    }
}
