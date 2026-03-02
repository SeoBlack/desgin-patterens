public class XMLPrinter extends PrinterDecorator {

    BasicPrinter printer;
    public XMLPrinter(BasicPrinter printer){
        this.printer = printer;
    }

    @Override
    public void print(String message){
        printer.print("<message>" + message + "</message>" );
    }
}
