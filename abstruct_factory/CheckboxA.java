public class CheckboxA extends Checkbox {

    public CheckboxA(String text) {
        super(text);
    }
    void display() {
        System.out.printf("-------CheckboxA[%s]------\n", this.text);
    }
}
