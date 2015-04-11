/**
 * Created by INTEL on 10/4/2015.
 */
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.IOException;
import org.json.simple.parser.*;
import org.json.simple.*;

public class Main {

    public static void main(String[] args) throws IOException {


        String s = "{\n" +
                "\"topic\":\"Football\",\n" +
                "\"hashtag\":\"#Arsenal\",\n" +
                "\"category\":[\n" +
                "{\"name\":\"Arsenal\", \"keys\":[\"arsenal\",\"The Gunners\",\"Premier League\"]},\n" +
                "{\"name\":\"Liverpool\", \"keys\":[\"Anfield\",\"liverpool\",\"barca\"]},\n" +
                "{\"name\":\"MU\", \"keys\":[\"manchester\",\"united\"]}\n" +
                "]\n" +
                "}";

        MatchEngine me = new MatchEngine();
        me.run(s);

        /* JSON ENCODE */
        /*JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj);*/

    }

}
