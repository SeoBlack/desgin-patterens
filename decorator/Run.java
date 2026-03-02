public class Run {
    public static void main (String [] args){
        BasicPrinter printer = new BasicPrinter();
        printer.print("Hello World! basic");


        //children
        BasicPrinter printer2 = new EncryptedPrinter(printer);
        printer2.print("Hello World!");
        BasicPrinter printer3 = new XMLPrinter(printer2);
        printer3.print("Hello World!");



    }
}
