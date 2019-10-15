package Office;

import java.util.Objects;

 public class Person {
    TestingProtectedInnerClass testingProtectedInnerClass;
    private String ID;
    private String name;

   public Person() {
        ID = "";
        name = "";
    }

   public Person( String ID, String name ) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash( ID, name );
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Person person = ( Person ) o;
        return Objects.equals( ID, person.ID ) &&
                       Objects.equals( name, person.name );
    }

    @Override
    public String toString() {
        return "Person{" +
                       "ID='" + ID + '\'' +
                       ", name='" + name + '\'' +
                       '}';
    }

    String getID() {
        return ID;
    }

    void setID( String ID ) {
        this.ID = ID;
    }

    public boolean getName() {
        return true;
    }

    void setName( String name ) {
        this.name = name;
    }


    /*
    * Below class is to test protected Keyword in java
    *
    * */
    public class TestingProtectedInnerClass {
        private int id;
        private String name;

        public TestingProtectedInnerClass( int id, String name ) {
            this.id = id;
            this.name = name;
        }

        public void testMethod() {
            System.out.println( "printing default values" );
            if ( ID.isEmpty() ) {
                ID = "EMPTY";
            }
        }
    }
}
