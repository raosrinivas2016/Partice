/*
 * ComparisionUtils.java
 *
 * Created on July 24, 2006, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package general;

/**
 *
 * @author bdickie
 */
public class ComparisionUtils {
    public static boolean equals(Object obj1, Object obj2) {
        if (obj1 == obj2)
            return true;
        else if (obj1 == null || obj2 == null)
            return false;
        else
            return obj1.equals(obj2);
    }
    
    public static int compare(Comparable obj1, Comparable obj2) {
        if (obj1 == obj2)
            return 0;
        else if (obj1 == null)
            return -1;
        else if (obj2 == null)
            return 1;
        else
            return obj1.compareTo(obj2);
    }
    
    public static boolean deepEquals(Object[] obj1, Object[] obj2) {
        if (obj1 == obj2)
            return true;
        else if (obj1 == null || obj2 == null)
            return false;
        else if (obj1.length != obj2.length)
            return false;
        
        for(int i = 0; i < obj1.length; i++) {
            if (!equals(obj1[i], obj2[i]))
                return false;
        }
        return true;
    }
}
