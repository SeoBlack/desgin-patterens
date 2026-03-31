import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private String extension;
    private List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // nothing needed here
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}