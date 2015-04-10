/**
 * Created by INTEL on 10/4/2015.
 */
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import twitter4j.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TwitterException, IOException {

        API t = new API();
        t.fetch("premier league", 100);
        System.out.println("Fetched " + t.getArrSize() + " tweets");

        MatchEngine me = new MatchEngine();

        /* Adding Keyword */
        Category cat1 = new Category(1, "Arsenal");
        cat1.addKey("arsenal");
        cat1.addKey("The Gunners");
        cat1.addKey("Premier League");

        me.addCategory(cat1);

        cat1 = new Category(2, "Liverpool");
        cat1.addKey("Anfield");
        cat1.addKey("liverpool");

        me.addCategory(cat1);

        me.StringMatcher(t);
        System.out.println(t.getTweet(45).category);


    }

}
