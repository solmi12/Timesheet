pipeline {
    agent any
    stages{
        stage ("Checkout GIT"){
            steps{
                echo "pulling...";
                git branch:'main' ,url : 'https://github.com/solmi12/TimesheetProject-.git-'
            }
        }
        
        stage ("Test,Build,Sonar"){
            steps {
                bat 'mvn package sonar:sonar'
            }
        }
        stage ("deploy to nexus"){
            steps {
                bat 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST- -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/  -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.jar'
    }
        }
    }
}
