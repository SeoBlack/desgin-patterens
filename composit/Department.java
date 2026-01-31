import java.util.ArrayList;
import java.util.List;

class Department extends Component {
    private List<Component> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }
    public void addNode(Component component) {
        children.add(component);

    }
    public void removeNode(Component component) {
        children.remove(component);

    }

    @Override
    public double getSalary() {
        double result = 0;
        for  (Component component : children) {
            result += component.getSalary();


        }
        return result;
    }
    @Override
    public String getXML(String indent) {
        StringBuilder xmlString = new StringBuilder();
        xmlString.append(indent + "<Department name=\"" + name + "\">\n");

        for (Component child : children) {
            xmlString.append(child.getXML(indent + "  "));
        }

        xmlString.append(indent + "</Department>\n");
        return xmlString.toString();
    }
}