pipeline{
  environment { 
        registry = "ahmedchokri/wevioo" 
        registryCredential = '7b35ef37-b235-4fa7-8fd9-00c633a63e47' 
        dockerImage = '' 
    }
agent any
stages{
stage("build"){
steps {
sh "mvn compile"
}
}
stage("Nexus") {
steps {
sh " mvn clean package deploy:deploy-file -DgroupId=com.camunda.workflow -DartifactId=Camunda -Dversion=1.0.0-SNAPSHOT -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.0.10:8081/repository/maven-snapshots/ -Dfile=target/Camunda-1.0.0-SNAPSHOT.jar"

}}
    stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
   stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
}
}