import java.util.List;

public class ProxyMain {
    public static void main(String[] args) {
        Library library = new Library();

        User alice = new User("alice");
        User bob = new User("bob");
        User admin = new User("admin");

        // Unprotected document
        IDocument publicDoc = library.addUnprotectedDocument("Public content: anyone can read this.");

        // Protected documents
        IDocument protectedForAlice = library.addProtectedDocument(
                "Secret for Alice only.",
                List.of(alice)
        );
        IDocument protectedForAdmin = library.addProtectedDocument(
                "Top secret: admin only.",
                List.of(admin)
        );

        System.out.println("=== Metadata is always public ===");
        System.out.println("publicDoc id=" + publicDoc.getId() + ", created=" + publicDoc.getCreationDate());
        System.out.println("protectedForAlice id=" + protectedForAlice.getId() + ", created=" + protectedForAlice.getCreationDate());
        System.out.println("protectedForAdmin id=" + protectedForAdmin.getId() + ", created=" + protectedForAdmin.getCreationDate());

        System.out.println();
        System.out.println("=== Content access ===");

        System.out.println("Alice reads publicDoc: " + publicDoc.getContent(alice));
        System.out.println("Bob reads publicDoc: " + publicDoc.getContent(bob));

        System.out.println("Alice reads protectedForAlice: " + protectedForAlice.getContent(alice));
        try {
            System.out.println("Bob reads protectedForAlice: " + protectedForAlice.getContent(bob));
        } catch (AccessDeniedException ex) {
            System.out.println("Bob reads protectedForAlice: " + ex.getMessage());
        }

        System.out.println("Admin reads protectedForAdmin: " + protectedForAdmin.getContent(admin));
        try {
            System.out.println("Alice reads protectedForAdmin: " + protectedForAdmin.getContent(alice));
        } catch (AccessDeniedException ex) {
            System.out.println("Alice reads protectedForAdmin: " + ex.getMessage());
        }

        try {
            System.out.println("Null user reads protectedForAdmin: " + protectedForAdmin.getContent(null));
        } catch (AccessDeniedException ex) {
            System.out.println("Null user reads protectedForAdmin: " + ex.getMessage());
        }
    }
}

