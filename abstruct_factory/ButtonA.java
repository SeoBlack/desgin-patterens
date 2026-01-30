public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }
    void display() {
        System.out.printf("-------ButtonA[%s]------\n", this.text);
    }
}
