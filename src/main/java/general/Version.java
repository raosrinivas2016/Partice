/*
 * Version.java
 *
 * Created on October 17, 2006, 12:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package general;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author bdickie
 */
public class Version implements Comparable, Serializable {

    private ArrayList<Integer> parts;

    public Version() {
        this( "0" );
    }

    /**
     * Creates a new instance of Version
     *
     * @param desc
     */
    public Version( String desc ) {
        String[] descParts = desc.split( "\\." );
        parts = new ArrayList<Integer>( descParts.length );
        for ( String descPart : descParts ) {
            parts.add( Integer.valueOf( descPart ) );
        }
    }

    @Override
    public int hashCode() {
        int res = 0;
        for ( int part : parts ) {
            res += part;
        }
        return res;
    }

    @Override
    public boolean equals( Object o ) {
        if ( o instanceof Version ) {
            return compareTo( o ) == 0;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return CollectionsUtil.join( parts, "." );
    }

    public boolean lessThen( Object o ) {
        return compareTo( o ) < 0;
    }

    public int getPart( int index ) {
        return parts.get( index );
    }

    @Override
    public int compareTo( Object o ) {
        if ( o == null ) {
            return 1;
        } else if ( o instanceof Version ) {
            throw new NullPointerException();
        } else if  ( o instanceof Version ) {
            Version v = ( Version ) o;
            int minLen = Math.min( parts.size(), v.parts.size() );
            for ( int i = 0; i < minLen; i++ ) {
                int cmp = parts.get( i ).compareTo( v.parts.get( i ) );
                if ( cmp != 0 ) {
                    return cmp;
                }
            }
            if ( parts.size() > v.parts.size() ) {
                return 1;
            } else if ( parts.size() == v.parts.size() ) {
                return 0;
            } else {
                return -1;
            }
        } else{
            return compareTo( new Version( o.toString() ) );
        }
    }

    public String toStringWithoutBuild() {
        return String.format( "%d.%02d", parts.get( 0 ), parts.get( 1 ) );
    }

}
