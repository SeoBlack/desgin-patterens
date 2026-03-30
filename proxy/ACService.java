import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ACService {
    private static ACService instance;

    // username : [allowed document ids]
    private final Map<String, Set<String>> allowListByUser = new HashMap<>();

    private ACService() {}

    public static synchronized ACService getInstance() {
        if (instance == null) {
            instance = new ACService();
        }
        return instance;
    }

    public void allow(String username, String documentId) {
        allowListByUser.computeIfAbsent(username, k -> new HashSet<>()).add(documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        Set<String> allowed = allowListByUser.get(username);
        return allowed != null && allowed.contains(documentId);
    }
}
