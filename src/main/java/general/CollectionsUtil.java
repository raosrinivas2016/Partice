/*
 * CollectionsUtil.java
 *
 * Created on March 22, 2006, 1:47 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package general;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bdickie
 */
public class CollectionsUtil {

    public static <T> T selectItem( Collection<T> collection ) {
        Iterator<T> i = collection.iterator();
        if ( i.hasNext() ) {
            return i.next();
        } else {
            return null;
        }
    }

    public static String join( Collection<? extends Object> list, String glue ) {
        StringBuffer buffer = new StringBuffer();
        join( list, glue, buffer );
        return buffer.toString();
    }

    public static void join( Collection<? extends Object> list, String glue, StringBuffer buffer ) {
        boolean start = false;
        for ( Object obj : list ) {
            if ( start ) {
                buffer.append( glue );
            } else {
                start = true;
            }

            buffer.append( String.valueOf( obj ) );
        }
    }

    public static String serializeToString( Map<String, String> map ) {
        StringBuffer out = new StringBuffer();
        boolean started = false;
        for ( Map.Entry<String, String> entry : map.entrySet() ) {
            if ( started ) {
                out.append( ", " );
            } else {
                started = true;
            }

            out.append( "'" );
            out.append( entry.getKey().replaceAll( "'", "''" ) );
            out.append( "'=>" );
            out.append( "'" );
            out.append( entry.getValue().replaceAll( "'", "''" ) );
            out.append( "'" );
        }
        return out.toString();
    }


    private static final Pattern valuePattern = Pattern.compile( "'([^']*(?:''[^']*)*)'=>'([^']*(?:''[^']*)*)'" );

    public static Map<String, String> deserializeFromString( String str ) {
        return deserializeFromString( str, new HashMap<String, String>() );
    }

    public static Map<String, String> deserializeFromString( String str, Map<String, String> into ) {
        if ( str != null ) {
            Matcher m = valuePattern.matcher( str );
            while ( m.find() ) {
                String name = m.group( 1 ).replaceAll( "''", "'" );
                String value = m.group( 2 ).replaceAll( "''", "'" );
                into.put( name, value );
            }
        }
        return into;
    }

    public static String serializeIntegerMap( Map<Integer, ? extends Collection<Integer>> map ) {
        StringBuffer result = new StringBuffer();
        for ( Map.Entry<Integer, ? extends Collection<Integer>> entry : map.entrySet() ) {
            result.append( entry.getKey() );
            result.append( ':' );
            join( entry.getValue(), ",", result );
            result.append( ';' );
        }
        return result.toString();
    }

    public static Map<Integer, Set<Integer>> deserializeIntegerMap( String serialization ) {
        Pattern p = Pattern.compile( "([-+]?\\d+):([-+]?\\d+(?:,[-+]?\\d+)*);" );
        Matcher m = p.matcher( serialization );
        Map<Integer, Set<Integer>> res = new HashMap<Integer, Set<Integer>>();
        while ( m.find() ) {
            Integer id = new Integer( m.group( 1 ) );
            HashSet<Integer> valSet = new HashSet<Integer>();
            String vals = m.group( 2 );
            if ( vals != null ) {
                String[] valsArray = vals.split( "," );
                for ( String str : valsArray ) {
                    valSet.add( new Integer( str ) );
                }
            }
            res.put( id, valSet );
        }
        return res;
    }

    public static <T, Y extends T> boolean contains( T[] array, Y value ) {
        for ( T t : array ) {
            if ( ComparisionUtils.equals( t, value ) ) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains( int[] array, int value ) {
        for ( int t : array ) {
            if ( t == value ) {
                return true;
            }
        }

        return false;
    }
}
