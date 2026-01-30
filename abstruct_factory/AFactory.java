public class AFactory extends UIFactory{
    ButtonA createButton(String text) {
        return new ButtonA(text);
    }
    TextFieldA createTextField(String text) {
        return new TextFieldA(text);
    }
    CheckboxA createCheckbox(String text){
        return new CheckboxA(text);
    }
}
