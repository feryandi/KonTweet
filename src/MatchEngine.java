import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.ListIterator;

public class MatchEngine {
    private ArrayList<Category> keyword = new ArrayList<>();
    private API api = new API();
    private String mainKey;
    private long algorithm;

    //menambahkan Category baru dalam yang ingin dimasukkan kedalam pencarian
    public void addCategory ( Category c ) {
        keyword.add(c);
    }

    //fungsi untuk menjalankan keseluruhan proses analisis
    public void run (String query, int amount) {
        JSONDecode(query);

        api.fetch(mainKey, amount);
        StringMatcher(api);
        api.sortTweet();

        JSONEncode();
    }
    //fungsi untuk mendapatkan API yang ingin di lakukan analisis
    public API getAPI () {
        return api;
    }

    //prosedure untuk mengubah inputan dari html menjadi array argument yang akan dimasukkan kedalam exec
    public void JSONDecode (String JSON) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(JSON);
            JSONObject input = (JSONObject)obj;

            mainKey = (input.get("hashtag")).toString();
            algorithm = (long) input.get("algorithm");

            JSONArray category = (JSONArray)input.get("category");
            for ( int i = 0; i < category.size(); ++i ) {
                JSONObject subcategory = (JSONObject)category.get(i);
                Category cat = new Category((i+1), subcategory.get("name").toString());

                JSONArray keywords = (JSONArray)subcategory.get("keys");
                for ( int j = 0; j < keywords.size(); ++j ) {
                    cat.addKey(keywords.get(j).toString());
                }

                addCategory(cat);
            }

        } catch (ParseException pe) {
            System.out.println("Exception");
        }
    }

    //fungsi yang mengembalikan string yang berisi hasil analisis untuk ditampilkan dalam html
    public String JSONEncode () {
        JSONArray output = new JSONArray();

        for ( int i = 0; i < api.getArrSize(); ++i ) {
            JSONObject tweet = new JSONObject();
            tweet.put("id", api.getTweetId(i));
            tweet.put("user", api.getUser(i));
            tweet.put("user_dp", api.getUserDp(i));
            tweet.put("msg", api.getMsg(i));
            tweet.put("date", (api.getDate(i)).getTime()); /*Need display convention*/
            tweet.put("category", api.getCategory(i));

            output.add(tweet);
        }

        System.out.println(output);

        return output.toJSONString();
    }

    //prosedure pencocokan string pada setiap tweet yang ada didalam API, lalu mengubah kategori-kategori tweet tersebut yang kategori yang tepat
    public void StringMatcher ( API a ) {

        ListIterator<Tweet> tweetIterator = a.getTweetData().listIterator();
        while( tweetIterator.hasNext() ) {
            Tweet t = tweetIterator.next();
            //boolean found = false;
            int catID = 0;
            int temp=-1;
            ListIterator<Category> categoryIterator = keyword.listIterator();
            while ( /*( !found ) &&*/ ( categoryIterator.hasNext() ) ) {
                ++catID;
                Category c = categoryIterator.next();

                ListIterator<String> keyIterator = (c.key).listIterator();
                while ( /*( !found ) && */( keyIterator.hasNext() ) ) {
                    String k = keyIterator.next();

                    if ( algorithm == 0 ) {
                    /* KMP */
                        if (kmpMatch((t.msg).toLowerCase(), k) != -1 ) {
                            if  (temp==-1 || kmpMatch((t.msg).toLowerCase(), k)<temp  ) {
                                temp = kmpMatch((t.msg).toLowerCase(), k);
                                t.category = catID;
                                //found = true;
                            }
                            t.msg=      (t.msg).replaceAll("(?i)" + k, "<b>" + k + "</b>");
                        }
                    } else {
                    /* BM */
                        if (bmMatch(t.msg.toLowerCase(), k) != -1) {
                            if  (temp==-1 || bmMatch((t.msg).toLowerCase(), k)<temp  ) {
                                temp = bmMatch((t.msg).toLowerCase(), k);
                                t.category = catID;
                                //found = true;
                            }
                            t.msg=      (t.msg).replaceAll("(?i)" + k, "<b>" + k + "</b>");
                        }
                   }
                }

            }
        }
    }

    //fungsi pinggiran untuk algoritma KMP
    public static int[] computeFail(String pattern) {
        int fail[] = new int[pattern.length()];
        fail[0] = 0;
        int m = pattern.length();
        int i = 1;
        int j = 0;
        while (i < m) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                fail[i] = j + 1;
                i++;
                j++;
            } else if (j > 0)
                j = fail[j - 1];
            else {
                fail[i] = 0;
                i++;
            }
        }
        return fail;
    }

    //algoritma pencocokan string KMP yang mengembalikan indeks dimana pattern ditemukan
    public static int kmpMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int fail[] = computeFail(pattern);
        int j = 0;
        int i = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == m - 1)
                    return i - m + 1;
                i++;
                j++;
            } else if (j > 0)
                j = fail[j - 1];
            else
                i++;
        }
        return -1;
    }

    //fungsi yang mengembalikan array of integer sebagai keberadaan terakhir karakter yang bersesuaian
    public static int[] buildLast(String pattern) {

        int last[] = new int[256];
        for (int i = 0; i < 256; i++) {
            last[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        }

        return last;
    }

    //algoritma pencocokan string BM
    public static int bmMatch(String text, String pattern)  {
        int last[] = buildLast(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = m - 1;
        if (i > n-1) {
            return -1;
        }
        int j = m-1;
        do {

            if (pattern.charAt(j) == text.charAt(i) ) {
                if (j == 0) {
                    return i;
                } else {
                    i--;
                    j--;
                }
            } else {
                int lo;
                if (text.charAt(i)>255 || text.charAt(i)<=0)
                    lo=-1;
                else
                    lo = last[text.charAt(i)];
                i = i + m - Math.min(j, 1+lo);
                j = m - 1;
            }
        } while (i <= n-1);
        return -1;
    }
}
