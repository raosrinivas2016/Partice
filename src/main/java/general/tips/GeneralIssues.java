package general.tips;

import java.util.Calendar;
import java.util.Date;

public class GeneralIssues {
    String name=null;
    public  void emptyStringCheck()  {
        if (!"".equals(name))
            System.out.println("proper way");

        try{
        if(name.equals("SomeThing")) {
            System.out.println("not proper way");
        }
        }catch (Exception e){
            System.out.println("good catch");;}

    }
    public void conditionCheckInsteadOfIfElse(){
//        if ("".equals(""))
//            System.out.println("empty");
//        else
//            System.out.println("not empty");

        //other way to do this
        System.out.println("".equals("")?"empty":"not empty");
    }


    public void workingWithCalendar(){
    Date date=new Date();
    date.getTime();
        System.out.println(date);
        Calendar calendar=Calendar.getInstance();

    }
}
