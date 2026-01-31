public class Employee extends Component {
    double salary;
    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary;

    }
    @Override
    public String getXML(String indent) {
        return indent + "<Employee name=\"" + this.name + "\" salary=\"" + this.salary + "\"/>\n";
    }
}