import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by INTEL on 10/4/2015.
 */

public class API {
    private ArrayList<Tweet> tweetData = new ArrayList<>();

    public void fetch (String hashtag, int amount) {
        int total_tweets = 0;

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Q3NhMsxZ8lgIojt7EbXAV6lip")
                .setOAuthConsumerSecret("uLdC7tLHjDZKSrrixefGF7VywGuMm6Nvbm2y8FUKmePilaDEvg")
                .setOAuthAccessToken("31103082-UQaL4JIsju0wAvwFXfFNfIQmAb9MADXcgG0SPhaAM")
                .setOAuthAccessTokenSecret("KwD6ZJDTKfc8zaGJSkRCXuHNZheLbSCPgIwrz512wyGnx");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();

        try {
            Query query = new Query(hashtag);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    //System.out.println("@" + tweet.getUser().getScreenName() + ":" + tweet.getText());
                    tweetData.add(new Tweet(tweet.getUser().getScreenName(), tweet.getText(), tweet.getCreatedAt()));
                    ++total_tweets;
                }
                query = result.nextQuery();
            } while (total_tweets <= amount);
        } catch (TwitterException te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
    }

    public ArrayList<Tweet> getTweetData () {
        return tweetData;
    }

    public Tweet getTweet (int index) {
        return (tweetData.get(index));
    }

    public String getUser (int index) {
        return (tweetData.get(index)).user;
    }

    public String getMsg (int index) {
        return (tweetData.get(index)).msg;
    }

    public Date getDate (int index) {
        return (tweetData.get(index)).date;
    }

    public int getArrSize () {
        return tweetData.size();
    }

    public void sortTweet () {
        Collections.sort(tweetData);
    }
}
