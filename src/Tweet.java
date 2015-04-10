/**
 * Created by INTEL on 10/4/2015.
 */
import java.util.*;

public class Tweet implements Comparable<Tweet> {
    public String user;
    public String msg;
    public Date date;
    public int category;


    public Tweet ( String user, String msg, Date date ) {
        this.user = user;
        this.msg = msg;
        this.date = date;
        category = -1;
    }

    @Override
    public int compareTo (Tweet other){
        if ( category < other.category ) {
            return 1;
        } else if ( category > other.category ) {
            return -1;
        } else {
            if ( date.after(other.date) ) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
