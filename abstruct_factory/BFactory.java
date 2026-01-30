public class BFactory extends UIFactory{
    ButtonB createButton(String text) {
        return new ButtonB(text);
    }
    TextFieldB createTextField(String text) {
        return new TextFieldB(text);
    }
    CheckboxB createCheckbox(String text){
        return new CheckboxB(text);
    }
}
