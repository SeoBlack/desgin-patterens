import java.util.HashMap;
import java.util.List;

public class Library {

    private final HashMap<String, IDocument> documents;
    public Library(){
        documents = new HashMap<>();
    }

    public IDocument addUnprotectedDocument(String content) {
        IDocument doc = new Document(content);
        documents.put(doc.getId(), doc);
        return doc;
    }
    public IDocument addProtectedDocument(String content, List<User> allowedUsers) {
        Document doc = new Document(content);
        ACService ac = ACService.getInstance();
        if (allowedUsers != null) {
            for (User user : allowedUsers) {
                if (user != null) {
                    ac.allow(user.getUsername(), doc.getId());
                }
            }
        }
        IDocument proxyDoc = new DocumentProxy(doc, ac);
        documents.put(proxyDoc.getId(), proxyDoc);
        return proxyDoc;
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }

    public void removeDocument(IDocument document){
        this.documents.remove(document.getId());
    }

}
