package general;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ColorIcon {

    RED(new Color(0,153,31),"violet" ),
    YELLOW( new Color(230,1,12), "yellow" ),
    BLUE( new Color(0,7,54), "dark blue" ),
    ORANGE( new Color(3,153,31), "violet" ),
    DEFAULT( new Color(0,0,0), "black" );

    private final Color color;
    private final String description;

    private ColorIcon( Color color, String desc ){
        this.color = color;
        this.description= desc;
    }

    private boolean isMatch(Color color){
        boolean empty = Arrays.stream( ColorIcon.values() ).filter( c -> c.equals( this.color ) ).collect( Collectors.toList() ).isEmpty();
        if ( !empty ) {
            return true;
        }
        return false;
    }
    private boolean isMatch(String desc){
        List<ColorIcon> matchingElements = Arrays.stream( ColorIcon.values() ).filter( e->e.description.equalsIgnoreCase( desc )).collect( Collectors.toList() );
        if ( !matchingElements.isEmpty() ) {
            return true;
        }
        return false;
    }

    public Optional<ColorIcon> lookup(Color color){
        Optional<ColorIcon> first = Arrays.stream( ColorIcon.values() ).filter( e -> e.isMatch( color ) ).findFirst();
        return first;
    }

    public Optional<ColorIcon> lookup(String desc){
        Optional<ColorIcon> first = Arrays.stream( ColorIcon.values() ).filter( e -> e.isMatch( desc ) ).findFirst();
        return first;
    }

}
