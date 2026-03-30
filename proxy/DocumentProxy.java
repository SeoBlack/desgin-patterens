public class DocumentProxy implements IDocument{
    private final IDocument document;
    private final ACService acService;
    public DocumentProxy(IDocument document, ACService acService){
        if (document == null) {
            throw new IllegalArgumentException("document cannot be null");
        }
        if (acService == null) {
            throw new IllegalArgumentException("acService cannot be null for protected documents");
        }
        this.document = document;
        this.acService = acService;

    }
    public DocumentProxy(IDocument document) { // unprotected
        if (document == null) {
            throw new IllegalArgumentException("document cannot be null");
        }
        this.document = document;
        this.acService = null;
    }
    public String getContent(User user) {
        if (this.acService == null) { // unprotected
            return this.document.getContent(user);
        }
        if (user == null) {
            throw new AccessDeniedException("Access denied: user is required for protected document " + document.getId());
        }
        if (this.acService.isAllowed(this.document.getId(), user.getUsername())) {
            return document.getContent(user);
        }
        throw new AccessDeniedException(
                "Access denied for user '" + user.getUsername() + "' to document " + document.getId()
        );

    }
    public String getCreationDate() {
        return document.getCreationDate();
    }
    public String getId(){
        return document.getId();
    }
}
