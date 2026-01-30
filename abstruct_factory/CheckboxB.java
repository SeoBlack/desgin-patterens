public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }
    void display() {
        System.out.printf("-------CheckboxB[%s]------\n", this.text);
    }
}
