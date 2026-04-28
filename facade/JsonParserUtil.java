import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParserUtil {

    public String getAttribute(String json, String attributeName) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(json);

        Object value = obj.get(attributeName);

        if (value == null) {
            throw new IllegalArgumentException(
                    "Attribute '" + attributeName + "' not found"
            );
        }

        return value.toString();
    }
}