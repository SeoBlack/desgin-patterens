import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public String get(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        try {
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != 200) {
                throw new IOException("HTTP error code: " + status);
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            return content.toString();

        } finally {
            con.disconnect();
        }
    }
}