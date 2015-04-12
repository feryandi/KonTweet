import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        String s = "{\n" +
                "\"topic\":\"Football\",\n" +
                "\"hashtag\":\"#Arsenal\",\n" +
                "\"algorithm\":1,\n" +
                "\"category\":[\n" +
                "{\"name\":\"Arsenal\", \"keys\":[\"arsenal\",\"The Gunners\",\"Premier League\"]},\n" +
                "{\"name\":\"Liverpool\", \"keys\":[\"Anfield\",\"liverpool\",\"barca\"]},\n" +
                "{\"name\":\"MU\", \"keys\":[\"manchester\",\"united\"]}\n" +
                "]\n" +
                "}";

        MatchEngine me = new MatchEngine();
        me.run(s, 25);

    }

}
