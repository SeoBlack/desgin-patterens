public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }
    void display() {
        System.out.printf("-------ButtonB[%s]------\n", this.text);
    }
}
