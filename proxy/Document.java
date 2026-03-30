import java.util.Date;
import java.util.UUID;

public class Document implements IDocument{

    private final String id;
    private final String creationDate;
    private final String content;
    public Document( String content) {
        //generate random Id:
        this.id = UUID.randomUUID().toString();
        this.creationDate = new Date().toString();
        this.content = content;
    }
    public String getId() {
        return id;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public String getContent(User user) {
        return content;
    }

}
