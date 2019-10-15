package Office;


public class PersonManager<P extends Person> {
    DBConnection conn;
    Person.TestingProtectedInnerClass testingProtectedInnerClass;


    PersonManager(){
         conn=new DBConnection();
    }
    private void getConn(){
        if(conn!=null)
             conn.getDBStatus();
        else
             conn.getDBStatus();
    }

}
