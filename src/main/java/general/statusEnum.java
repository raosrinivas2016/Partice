package general;
/*TODO
 * values() : to get all enum values
 * valueOf() : to match to another enum in form of string argument
 * toString() : String value of
 * == operator to compare two enum's.
 * */

public enum statusEnum {
    /*INITIATED( "initiated", 0 ),
    CREATED( "created", 1 ),
    STRARTED( "started", 2 ),
    PAUSED( "paused", 3 ),
    STOPED( "stoped", 4 ),
    COMPLETED( "completed", 5 );
    */
    INITIATED,
    CREATED,
    STARTED,
    PAUSED,
    STOPPED,
    COMPLETED;

    public String getStateStringValue( statusEnum statusEnum ) {
        return statusEnum.toString();
    }

    public int getStateValue( statusEnum statusEnum ) {
        switch ( statusEnum ) {
            case INITIATED:
                return 0;
            case CREATED:
                return 1;
            case STARTED:
                return 2;
            case PAUSED:
                return 3;
            case STOPPED:
                return 4;
            case COMPLETED:
                return 5;
            default:
                return -1;
        }

    }


}
