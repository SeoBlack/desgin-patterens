public class VisitorMain {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        File file1 = new File("notes.txt", 2.5);
        File file2 = new File("photo.jpg", 5.0);

        Directory subFolder = new Directory("documents");

        File file3 = new File("resume.txt", 1.2);
        File file4 = new File("presentation.ppt", 8.0);

        subFolder.addElement(file3);
        subFolder.addElement(file4);

        root.addElement(file1);
        root.addElement(file2);
        root.addElement(subFolder);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total size: "
                + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("TXT files found:");

        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println(file.getName());
        }
    }
}
