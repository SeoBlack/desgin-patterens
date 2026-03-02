public class XMLPrinter extends PrinterDecorator {

    BasicPrinter printer;
    public XMLPrinter(BasicPrinter printer){
        this.printer = printer;
    }

    @Override
    public void print(String message){
        System.out.println("Child was overridden by other child");
    }
}
