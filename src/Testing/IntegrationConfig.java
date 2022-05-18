package Testing;


/*https://www.toptal.com/java/unit-integration-junit-tests

or
https://maven.apache.org/plugins/maven-jar-plugin/examples/create-test-jar.html
https://www.youtube.com/watch?v=mrhhOqx4uzA
https://codeutility.org/eclipse-maven-dependency-jar-grayed-out-cant-import-classes-from-it-stack-overflow/

or

https://www.youtube.com/watch?v=zz3AcFpXSFI&ab_channel=vaadinofficial
*/



import ASTNodes.DclNodes.ListDclNode;

@Configuration
public class IntegrationConfig {

    @bean
    public ListDclNode listDclNode(){
        return new ListDclNode();
    }
}
