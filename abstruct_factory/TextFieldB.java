public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }
    void display() {
        System.out.printf("-------TextFieldB[%s]------\n", this.text);
    }
}
