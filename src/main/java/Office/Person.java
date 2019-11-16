package Office;

import java.util.Comparator;
import java.util.Objects;

 public class Person {
    TestingProtectedInnerClass testingProtectedInnerClass;
     private String ID = "-1";
     private String name = "";

     protected Person() {

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


     public int equals( Object o1, Object o2 ) {
         if ( o1 != null ) {
             Comparator<Person> personComparator = Comparator.comparing( Person :: getID );
             Person p1 = ( Person ) o1;
             Person p2 = ( Person ) o2;
             return personComparator.compare( p1, p2 );
         }
         throw new NullPointerException();
     }

     @Override
    public String toString() {
        /*return "Person{" +
                       "ID='" + getID() + '\'' +
                       ", name='" + getName() + '\'' +*/
         return getID() + getName();
     }

     public String printPerson() {
         System.out.println( getID() + getName() );
         return getID() + getName();
     }

     public String getID() {
        return ID;
    }

     public void setID( String ID ) {
        this.ID = ID;
    }

     private boolean getName() {
        return true;
    }

     public void setName( String name ) {
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

            if ( ID.isEmpty() ) {
                ID = "EMPTY";
            }
        }
    }
}
