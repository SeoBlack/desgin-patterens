public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }
    void display() {
        System.out.printf("-------TextFieldA[%s]------\n", this.text);
    }
}
