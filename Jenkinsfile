@Library('shared_stages')_
welcomeJob 'mvn clean package deploy:deploy-file -DgroupId=com.camunda.workflow -DartifactId=Camunda -Dversion=1.0.0-SNAPSHOT -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.0.10:8081/repository/maven-snapshots/ -Dfile=target/Camunda-1.0.0-SNAPSHOT.jar'