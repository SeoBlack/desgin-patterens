public class EncryptedPrinter extends PrinterDecorator {

    BasicPrinter printer;
    int shift = 8 ;
    public EncryptedPrinter(BasicPrinter printer) {
        this.printer = printer;
    }
    @Override
    public void print(String message){
        printer.print(encrypt(message));

    }
    private String encrypt(String message){
        char[] chars = message.toCharArray();
        for (int i=0; i < message.length(); i++)
        {
            char c = chars[i];
            if (c >= 32 && c <= 127)
            {
                int x = c - 32;
                x = (x + shift) % 96;
                if (x < 0)
                    x += 96; //java modulo can lead to negative values!
                chars[i] = (char) (x + 32);
            }
        }
        return new String(chars);
    }
}
