public class Composit {
    public static void main(String[] args) {
        Department HRdepartment = new Department("HR");
        Department ITdepartment = new Department("IT");
        Department DevelopDepartment = new Department("Main");

        Employee employee1 = new Employee("Laura", 1300);
        Employee employee2 = new Employee("Mikko", 1400);
        Employee employee3 = new Employee("Hanna", 1100);


        // Add first two Employees into the HR-Ddepartment:
        HRdepartment.addNode(employee1);
        HRdepartment.addNode(employee2);

        // Printing the Total Salary of Department before removing:
        System.out.println("The Total Salary of the Department before laying off: " + HRdepartment.getSalary() +"\n");
        // Remove employee from Department:
        HRdepartment.removeNode(employee2);

        // Add the one Employee into the IT-Ddepartment:
        ITdepartment.addNode(employee3);

        // Add the HR-Ddepartment and IT-Ddepartment into the Develop Department(this is what actully Com):
        DevelopDepartment.addNode(HRdepartment);
        DevelopDepartment.addNode(ITdepartment);



        // Printing the Total Salary of Department:
        System.out.println("The Total Salary of the Department after laying off: " + HRdepartment.getSalary() +"\n");


        // Print and convert Data to XML String
        System.out.println(DevelopDepartment.getXML(""));
    }
}
