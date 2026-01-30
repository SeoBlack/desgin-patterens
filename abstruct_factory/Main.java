public class Main  {
    public static void main(String[] args) {
        UIFactory UIA = new AFactory();
        UIFactory UIB = new BFactory();

        System.out.println("AFactory");
        UIA.createButton("Test").display();
        UIA.createCheckbox("Test2").display();
        UIA.createTextField("Test3").display();

        System.out.println("BFactory");
        UIB.createButton("Test").display();
        UIB.createCheckbox("Test2").display();
        UIB.createTextField("Test3").display();
    }
}