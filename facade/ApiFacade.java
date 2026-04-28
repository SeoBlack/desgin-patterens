import java.io.IOException;

public class ApiFacade {

    private final HttpClient httpClient;
    private final JsonParserUtil jsonParser;

    public ApiFacade() {
        this.httpClient = new HttpClient();
        this.jsonParser = new JsonParserUtil();
    }

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        try {
            String json = httpClient.get(urlString);
            return jsonParser.getAttribute(json, attributeName);

        } catch (IllegalArgumentException e) {
            throw e;

        } catch (Exception e) {
            throw new IOException("Failed to process API request", e);
        }
    }
}