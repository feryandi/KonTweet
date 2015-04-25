import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class API {
    private ArrayList<Tweet> tweetData = new ArrayList<>();


    public void fetch (String hashtag, int amount)
            //prosedur untuk mendapatkan tweet sebanyak amount yang memiliki mainkey "hashtag"
            //I.S. tweetData masih kosong
            //F.S. tweetData berisi tweet sebanyak amount yang memiliki hashtag tersebut
    {
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
            //query.setCount(amount);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    //System.out.println("@" + tweet.getUser().getScreenName() + ":" + tweet.getText() + " -id " + tweet.getId());
                    tweetData.add(new Tweet(tweet.getUser().getScreenName(), tweet.getText(), tweet.getCreatedAt(), tweet.getId(), tweet.getUser().getOriginalProfileImageURL()));
                    ++total_tweets;
                }
            } while ( (total_tweets <= amount) && ((query = result.nextQuery()) != null) );
        } catch (TwitterException te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
    }

    public ArrayList<Tweet> getTweetData () {
        return tweetData;
    }//fungsi untuk mendapatkan tweetData

    public Tweet getTweet (int index) { return (tweetData.get(index)); }//fungsi untuk mendapatkan tweet ke indeks

    public long getTweetId (int index) { return (tweetData.get(index)).tweet_id; }//fungsi untuk mendapatkan tweetid ke indeks

    public String getUser (int index) { return (tweetData.get(index)).user; }//fungsi untuk mendapatkan user tweet ke indeks

    public String getUserDp (int index) { return (tweetData.get(index)).user_dp; }//fungsi untuk mendapatkan user_dp tweet ke indeks

    public String getMsg (int index) {
        return (tweetData.get(index)).msg;
    }//fungsi untuk mendapatkan konten tweet ke indeks

    public Date getDate (int index) {
        return (tweetData.get(index)).date;
    }//fungsi untuk mendapatkan tanggal tweet ke indeks

    public int getCategory (int index) {
        return (tweetData.get(index)).category;
    }//fungsi untuk mendapatkan nomor kategori tweet ke indeks

    public int getArrSize () {
        return tweetData.size();
    }// fungsi untuk mendapatkan banyak tweet

    public void sortTweet () {
        Collections.sort(tweetData);
    }//prosedure untuk mengurutkan tweet berdasarkan kategori dan tanggal
    //I.S. array of tweet terdefinisi
    //F.S. array of tweet terurutkan
}
