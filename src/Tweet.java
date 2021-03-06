/**
 * Created by INTEL on 10/4/2015.
 */
import java.util.*;

public class Tweet implements Comparable<Tweet> {
    public String user;
    public String msg;
    public Date date;
    public int category;
    public String user_dp;
    public long tweet_id;

//konstruktor
    public Tweet ( String user, String msg, Date date, long tweet_id, String user_dp ) {
        this.user = user;
        this.msg = msg;
        this.date = date;
        this.user_dp = user_dp;
        this.tweet_id = tweet_id;
        category = -1;
    }

    @Override
    //fungsi perbandingan yang akan digunakan untuk proses pengurutan
    public int compareTo (Tweet other){
        if ( category < other.category ) {
            return -1;
        } else if ( category > other.category ) {
            return 1;
        } else {
            if ( date.after(other.date) ) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
