import java.io.IOException;

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
        me.run(s, 25);

        /* JSON ENCODE */
        /*JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj);*/

    }

}
