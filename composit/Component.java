public abstract class Component{
    String name;
    public Component(String name){
        this.name = name;

    }

    public  String getName(){
        return this.name;
    }

    public abstract String getXML(String indent);



    public abstract double getSalary();
}