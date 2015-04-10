import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by INTEL on 10/4/2015.
 */
public class MatchEngine {
    private ArrayList<Category> keyword = new ArrayList<>();

    public void addCategory ( Category c ) {
        keyword.add(c);
    }

    public void StringMatcher ( API a ) {

        ListIterator<Tweet> tweetIterator = a.getTweetData().listIterator();
        while( tweetIterator.hasNext() ) {
            Tweet t = tweetIterator.next();
            boolean found = false;
            int catID = 0;

            ListIterator<Category> categoryIterator = keyword.listIterator();
            while ( ( !found ) && ( categoryIterator.hasNext() ) ) {
                ++catID;
                Category c = categoryIterator.next();

                ListIterator<String> keyIterator = (c.key).listIterator();
                while ( ( !found ) && ( keyIterator.hasNext() ) ) {
                    String k = keyIterator.next();

                    /* CHANGE CODE BELOW TO KMP OR BOOYER-MOYES */
                    if ( ((t.msg).toLowerCase()).matches("(.*)" + k.toLowerCase() + "(.*)") ) {
                        t.category = catID;

                        System.out.println("FOUND : " + t.msg);

                        found = true;
                    }
                    /* CHANGE CODE ABOVE TO KMP OR BOOYER-MOYES */

                }

            }
        }
    }
}
