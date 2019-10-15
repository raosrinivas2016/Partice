/*
 * KeyGroupedMap.java
 *
 * Created on June 22, 2006, 11:18 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package Personal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



// to know how its used in Accuro , check LetterDBConnection.java
/**
 *
 * @author Blake Dickie
 * @param <T> - Key
 * @param <U> - Values
 */
public class KeyGroupedMap<T, U> implements Map<T, ArrayList<U>>, Serializable {

    private final Map<T, ArrayList<U>> map;
    private boolean createNewListsOnGet;

    public KeyGroupedMap( Map<T, ArrayList<U>> map ) {
        this.map = map;
    }

    public static <T, U> KeyGroupedMap<T, U> createHashMap() {
        return new KeyGroupedMap<>( new HashMap<T, ArrayList<U>>() );
    }

    public static <K extends Enum<K>, U> KeyGroupedMap<K, U> createEnumMap( Class<K> enumClass ) {
        return new KeyGroupedMap<>( new EnumMap<K, ArrayList<U>>( enumClass ) );
    }

    public static <T, U> KeyGroupedMap<T, U> createOrderedHashMap() {
        return new KeyGroupedMap<>( new LinkedHashMap<T, ArrayList<U>>() );
    }

    public static <T, U> KeyGroupedMap<T, U> createTreeMap() {
        return new KeyGroupedMap<>( new TreeMap<T, ArrayList<U>>() );
    }

    public static <T, U> KeyGroupedMap<T, U> createTreeMap( Comparator<T> comparator ) {
        return new KeyGroupedMap<>( new TreeMap<T, ArrayList<U>>( comparator ) );
    }

    public void setupKey( T key ) {
        ArrayList<U> list;
        if ( !containsKey( key ) ) {
            list = new ArrayList<>();
            put( key, list );
        }
    }

    public void putValue( T key, U value ) {
        ArrayList<U> list;
        if ( containsKey( key ) ) {
            list = get( key );
        } else {
            list = new ArrayList<>();
            put( key, list );
        }
        list.add( value );
    }

    public boolean removeValue( T key, U value ) {
        if ( containsKey( key ) ) {
            ArrayList<U> list = get( key );
            return list.remove( value );
        }
        return false;
    }

    public void putAll( T key, Collection<? extends U> value ) {
        ArrayList<U> list;
        if ( containsKey( key ) ) {
            list = get( key );
        } else {
            list = new ArrayList<>( value.size() );
            put( key, list );
        }
        list.addAll( value );
    }

    public int valuesCount() {
        int count = 0;
        for ( Collection<?> list : values() ) {
            count += list.size();
        }
        return count;
    }

    public List<U> getValues() {
        List<U> l = new ArrayList<>();
        for ( Collection<U> list : values() ) {
            l.addAll( list );
        }
        return l;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsValue( Object value ) {
        return map.containsValue( value );
    }

    @Override
    public ArrayList<U> put( T key, ArrayList<U> value ) {
        return map.put( key, value );
    }

    @Override
    public void putAll( Map<? extends T, ? extends ArrayList<U>> m ) {
        map.putAll( m );
    }

    @Override
    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<ArrayList<U>> values() {
        return map.values();
    }

    @Override
    public Set<Entry<T, ArrayList<U>>> entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean containsKey( Object key ) {
        return map.containsKey( key );
    }

    @Override
    public ArrayList<U> get( Object key ) {
        ArrayList<U> result = map.get( key );
        if ( result == null && createNewListsOnGet ) {
            result = new ArrayList<>();
            map.put( (T) key, result );
        }
        return result;
    }

    @Override
    public ArrayList<U> remove( Object key ) {
        return map.remove( key );
    }

    @Override
    public void clear() {
        for ( ArrayList list : values() ) {
            list.clear();
        }
        map.clear();
    }

    public boolean isCreateNewListsOnGet() {
        return createNewListsOnGet;
    }

    public void setCreateNewListsOnGet( boolean createNewListsOnGet ) {
        this.createNewListsOnGet = createNewListsOnGet;
    }
}
