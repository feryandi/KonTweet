import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        String s = "{\n" +
                "\"topic\":\"Football\",\n" +
                "\"hashtag\":\"#Arsenal\",\n" +
                "\"algorithm\":0,\n" +
                "\"category\":[\n" +
                "{\"name\":\"Arsenal\", \"keys\":[\"arsenal\",\"The Gunners\",\"Premier League\"]},\n" +
                "{\"name\":\"Liverpool\", \"keys\":[\"Anfield\",\"liverpool\",\"barca\"]},\n" +
                "{\"name\":\"MU\", \"keys\":[\"manchester\",\"united\"]}\n" +
                "]\n" +
                "}";

        String a = "{\"topic\":\"Testcase\",\"hashtag\":\"#Arsenal\",\"algorithm\":1,\"category\":[{\"name\":\"Arsenal\",\"keys\":[\"premier league\",\"arsenal\",\"bola\"]},{\"name\":\"b\",\"keys\":[\"AED\",\"aekj\",\"j\",\"da\"]}]}";


        MatchEngine me = new MatchEngine();

        me.run(args[0], 25);
        //me.run(a, 25);

    }

}
