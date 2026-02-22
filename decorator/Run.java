public class Run {
    public static void main (String [] args){
        BasicPrinter printer = new BasicPrinter();
        printer.print("Hello World!");

        BasicPrinter printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

    }
}
