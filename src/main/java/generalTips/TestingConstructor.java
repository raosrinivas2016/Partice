package generalTips;



import Office.Person;
import Office.PersonManager;

public class   TestingConstructor extends Person {

    String id;
    String name;
    PersonManager personManager;
    TestingProtectedInnerClass testingProtectedInnerClass;

     void test() {

    }

    TestingConstructor( String id, String name ) {

        this.id = id;
        this.name = name;
    }

    TestingConstructor() {
        this.name = name;
        this.id = id;
    }
}
